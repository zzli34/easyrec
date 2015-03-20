/*
 * Copyright 2015 Research Studios Austria Forschungsgesellschaft mBH
 *
 * This file is part of easyrec.
 *
 * easyrec is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * easyrec is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with easyrec.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.easyrec.plugin.aggregator.impl;

import com.google.common.base.Strings;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.easyrec.plugin.aggregator.model.AggregatorConfiguration;
import org.easyrec.service.core.TenantService;
import org.easyrec.service.domain.TypeMappingService;

import java.util.*;
import org.easyrec.model.core.ActionVO;
import org.easyrec.model.core.ItemVO;
import org.easyrec.model.core.web.Item;
import org.easyrec.plugin.aggregator.AggregatorGenerator;
import org.easyrec.plugin.aggregator.AggregatorService;
import org.easyrec.plugin.aggregator.model.AggregatorConfigurationInt;
import org.easyrec.plugin.aggregator.model.AggregatorStatistics;
import org.easyrec.plugin.aggregator.model.FieldConfiguration;
import org.easyrec.plugin.aggregator.store.dao.AggregatorActionDAO;
import org.easyrec.plugin.aggregator.store.dao.AggregatorLogEntryDAO;
import org.easyrec.service.core.impl.JSONProfileServiceImpl;
import org.easyrec.store.dao.IDMappingDAO;
import org.easyrec.store.dao.core.ItemDAO;
import org.easyrec.store.dao.core.types.ItemTypeDAO;

/**
 * <DESCRIPTION>
 * <p/>
 * <p><b>Company:&nbsp;</b>
 * SAT, Research Studios Austria</p>
 * <p/>
 * <p><b>Copyright:&nbsp;</b>
 * (c) 2007</p>
 * <p/>
 * <p><b>last modified:</b><br/>
 * $Author: pmarschik $<br/>
 * $Date: 2011-02-11 18:35:47 +0100 (Fr, 11 Feb 2011) $<br/>
 * $Revision: 17681 $</p>
 *
 * @author Stephan Zavrel
 */
public class AggregatorServiceImpl implements AggregatorService {
    private TypeMappingService typeMappingService;
    private TenantService tenantService;
    private AggregatorActionDAO aggregatorActionDAO;
    private JSONProfileServiceImpl jsonProfileService;
    private ItemDAO itemDAO;
    private IDMappingDAO idMappingDAO;
    private ItemTypeDAO itemTypeDAO;
    private AggregatorLogEntryDAO logEntryDAO;

    // logging
    private final Log logger = LogFactory.getLog(this.getClass());

    public AggregatorServiceImpl(TypeMappingService typeMappingService, TenantService tenantService, AggregatorActionDAO aggregatorActionDAO, JSONProfileServiceImpl jsonProfileService, ItemDAO itemDAO, IDMappingDAO idMappingDAO, ItemTypeDAO itemTypeDAO, AggregatorLogEntryDAO logEntryDAO) {
        this.typeMappingService = typeMappingService;
        this.tenantService = tenantService;
        this.aggregatorActionDAO = aggregatorActionDAO;
        this.jsonProfileService = jsonProfileService;
        this.itemDAO = itemDAO;
        this.idMappingDAO = idMappingDAO;
        this.itemTypeDAO = itemTypeDAO;
        this.logEntryDAO = logEntryDAO;
    }

    @Override
    public List<Integer> getUsersWithActions(AggregatorConfigurationInt configurationInt) {
        
        return aggregatorActionDAO.getUsersWithActions(configurationInt);
    }

    @Override
    public List<ActionVO<Integer,Integer>> getActionsForUser(Integer userId, AggregatorConfigurationInt configurationInt) {
        
        return aggregatorActionDAO.getActionsForUsers(userId, configurationInt);
    }
    
    @Override
    public void aggregateUserProfile(Integer userId, List<ActionVO<Integer,Integer>> actions, AggregatorConfigurationInt configurationInt) {
        
        //if user profile not exists, create it
        String userIdStr = idMappingDAO.lookup(userId);
        boolean newProfile = false;
        Item userItem = itemDAO.get(configurationInt.getTenantId(), userIdStr, AggregatorGenerator.ITEMTYPE_USER);
        LinkedHashMap<String, Object> userProfile = null;
        if (userItem == null) {
            userItem = itemDAO.add(configurationInt.getTenantId(), userIdStr, AggregatorGenerator.ITEMTYPE_USER, userIdStr, "", "");
            jsonProfileService.storeProfile(userItem.getTenantId(), userItem.getItemId(), userItem.getItemType(), "{}");
        } else {
            try {
                // if doDeltaUpdate load existing user profile
                if (configurationInt.getLastRun() != null) userProfile = (LinkedHashMap<String,Object>) jsonProfileService.loadProfileField(configurationInt.getTenantId(), userIdStr, AggregatorGenerator.ITEMTYPE_USER, "$.upa"); //TODO: parse json;    
            } catch (Exception ex) {
                logger.info("Could not load aggregator profile! Creating new one!",ex);
            }
        }
        if (userProfile == null) userProfile = new LinkedHashMap<>();

        ItemVO<Integer,Integer> prevItem = null;
        for (ActionVO<Integer, Integer> action : actions) {
            // only if config for actionInfo, evaluate actions, otherwise continue until next itemID,typeID
            if(!configurationInt.getProfileFields().isEmpty()) { // item profile content is interesting
                if (!action.getItem().equals(prevItem)) { // in case the item is new -> load profile and get the fields
                    prevItem = action.getItem();
                    Object profile = jsonProfileService.getProfileParsed(action.getItem());
                    if (profile != null) {
                    //get fields stuff here
                        for (FieldConfiguration fc : configurationInt.getProfileFields()) {
                            addFieldToUserProfile(fc, profile, userProfile);
                        }
                    }
                }
                    
            }
            
        if(!configurationInt.getActionFields().isEmpty()) { //in case actionInfo content is interesting
            String actionInfo = action.getActionInfo();
            Object actionProfile = configurationInt.getConfiguration().jsonProvider().parse(actionInfo);
            for (FieldConfiguration fc : configurationInt.getActionFields()) {
                addFieldToUserProfile(fc, actionProfile, userProfile);
            }
            //get fields stuff here
        }
        }

        try {
            jsonProfileService.storeProfileFieldParsed(userItem.getTenantId(), userItem.getItemId(), userItem.getItemType(), "$", "upa", userProfile);
        } catch (Exception ex) {
            logger.error("An error occured storing the user profile", ex);
        }
        
    }

    private void addFieldToUserProfile(FieldConfiguration fc, Object sourceProfile, LinkedHashMap<String,Object> userProfile) {
        try {
            Object field = fc.getJsonPath().read(sourceProfile);
            if (!(field instanceof String)) {
                field = field.toString();
            }
        //                        if (field instanceof ArrayList) {
        //                            
        //                        } else {
        //                            
        //                        }
            LinkedHashMap<String, Object> outputField = (LinkedHashMap<String, Object>) userProfile.get(fc.getOutputField());
            if (outputField == null) {
                outputField = new LinkedHashMap<>();
                userProfile.put(fc.getOutputField(), outputField);
            }
            Integer counter = (Integer) outputField.get(field);
            if (counter == null) { 
                counter = 1;
            } else {
                counter++;
            }
            outputField.put((String) field, (Object) counter);
        } catch (PathNotFoundException pnfe) {
            logger.debug("Path not found in profile " + pnfe.getMessage());
        }
        
    }
    
    @Override
    public Integer getNumberOfActions(AggregatorConfigurationInt intConfiguration, Date lastRun) {
        return aggregatorActionDAO.getNumberOfActions(intConfiguration.getTenantId(), intConfiguration.getActionType(), lastRun);
    }
    
    
    @Override
    public AggregatorConfigurationInt mapTypesToConfiguration(AggregatorConfiguration configuration) throws Exception {

        AggregatorConfigurationInt ret;

        ret = new AggregatorConfigurationInt(configuration.getTenantId(), null ,new ArrayList<Integer>(), null, configuration.getMaxRulesPerItem(), configuration.getDoDeltaUpdate(), configuration.getLastRun());

//        Integer actionId = typeMappingService.getIdOfActionType(configuration.getTenantId(), configuration.getActionType());
//        if (actionId == null) {
//            String sb = "Action '" + configuration.getActionType() + "' not valid for Tenant '" + configuration.getTenantId() + "'! Action will not be considered in Rulemining!";
//            logger.info(sb);
//        }
        ret.setActionType(null);
        Integer typeUser;
        try {
            typeUser = itemTypeDAO.getIdOfType(configuration.getTenantId(), AggregatorGenerator.ITEMTYPE_USER);
        } catch (IllegalArgumentException iae) {
            logger.info("itemType USER not found for tenant " + configuration.getTenantId() + "! Adding now.");
            typeUser = itemTypeDAO.insertOrUpdate(configuration.getTenantId(), AggregatorGenerator.ITEMTYPE_USER, Boolean.TRUE);
        }

        ret.setItemTypeUser(typeUser);

        for (String type : configuration.getItemTypes()) {
            Integer itemTypeId = typeMappingService.getIdOfItemType(configuration.getTenantId(), type);
            if (itemTypeId != null) {
                ret.getItemTypes().add(itemTypeId);
            } else {
                logger.info("ItemType '" + type + "' not valid for Tenant '" + configuration.getTenantId() +
                        "'! ItemType will not be considered in rulemining!");
            }
        }
        if (ret.getItemTypes() == null) {
            String sb = "No valid ItemTypes defined for Tenant '" + configuration.getTenantId() + "'! Skipping this rulemining configuration!";
            logger.info(sb);
            throw new Exception(sb);
        }

        Integer assocTypeId = typeMappingService.getIdOfAssocType(configuration.getTenantId(), configuration.getAssociationType());
        if (assocTypeId == null) {
            String sb = "AssocType '" + configuration.getAssociationType() + "' not valid for Tenant '" + configuration.getTenantId() + "'! Skipping analysis!";
            logger.info(sb);
            throw new Exception(sb);
        }
        ret.setAssocType(assocTypeId);
        
        if (!Strings.isNullOrEmpty(configuration.getActionInfoFields())) {
            String[] fields = configuration.getActionInfoFields().split(";");
            for (String field : fields) {
                String[] fieldInfo = field.split(",");
                JsonPath jp = JsonPath.compile(fieldInfo[1]);
                FieldConfiguration fc = new FieldConfiguration(fieldInfo[0], jp);
                ret.getActionFields().add(fc);
            }
        }
        
        if (!Strings.isNullOrEmpty(configuration.getItemProfileFields())) {
            String[] fields = configuration.getItemProfileFields().split(";");
            for (String field : fields) {
                String[] fieldInfo = field.split(",");
                JsonPath jp = JsonPath.compile(fieldInfo[1]);
                FieldConfiguration fc = new FieldConfiguration(fieldInfo[0], jp);
                ret.getProfileFields().add(fc);
            }
        }

        if (configuration.getDoDeltaUpdate()) {
            ret.setLastRun(logEntryDAO.getLastLogEntryForTenant(configuration.getTenantId(), assocTypeId, AggregatorGenerator.ID, AggregatorGenerator.VERSION));
        }
        
        return ret;

    }

    @Override
    public void removeOldRules(AggregatorConfigurationInt configuration,
                               AggregatorStatistics stats) {

//        itemAssocDAO.removeItemAssocByTenant(configuration.getTenantId(), configuration.getAssocType(),
//                typeMappingService.getIdOfSourceType(configuration.getTenantId(), AggregatorGenerator.ID.toString() + "/" + AggregatorGenerator.VERSION),
//                stats.getStartDate());
    }

//    private String extractKey(String jsonPath) {
//        
//        String[] tokens = jsonPath.split(".");
//        String tmp = tokens[tokens.length-1]; 
//        if ("*".equals(tmp)) {
//            tmp = tokens[tokens.length-2];
//        }
//        if (tmp.endsWith("]")) {
//            tmp = tmp.substring(0, tmp.lastIndexOf("[")-1);
//        }
//        return tmp;
//    }
    
    // getters and setters
    public TypeMappingService getTypeMappingService() {
        return typeMappingService;
    }

    public void setTypeMappingService(TypeMappingService typeMappingService) {
        this.typeMappingService = typeMappingService;
    }

    public TenantService getTenantService() {
        return tenantService;
    }

    public void setTenantService(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    public AggregatorActionDAO getAggregatorActionDAO() {
        return aggregatorActionDAO;
    }

    public void setAggregatorActionDAO(AggregatorActionDAO aggregatorActionDAO) {
        this.aggregatorActionDAO = aggregatorActionDAO;
    }

    public JSONProfileServiceImpl getJsonProfileService() {
        return jsonProfileService;
    }

    public void setJsonProfileService(JSONProfileServiceImpl jsonProfileService) {
        this.jsonProfileService = jsonProfileService;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public IDMappingDAO getIdMappingDAO() {
        return idMappingDAO;
    }

    public void setIdMappingDAO(IDMappingDAO idMappingDAO) {
        this.idMappingDAO = idMappingDAO;
    }

    public ItemTypeDAO getItemTypeDAO() {
        return itemTypeDAO;
    }

    public void setItemTypeDAO(ItemTypeDAO itemTypeDAO) {
        this.itemTypeDAO = itemTypeDAO;
    }

    public AggregatorLogEntryDAO getLogEntryDAO() {
        return logEntryDAO;
    }

    public void setLogEntryDAO(AggregatorLogEntryDAO logEntryDAO) {
        this.logEntryDAO = logEntryDAO;
    }

}
