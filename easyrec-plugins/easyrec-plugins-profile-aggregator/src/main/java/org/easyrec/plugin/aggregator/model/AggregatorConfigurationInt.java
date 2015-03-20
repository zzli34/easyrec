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

package org.easyrec.plugin.aggregator.model;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author szavrel
 */
public class AggregatorConfigurationInt {

    private Integer tenantId;
    private Integer assocType;
    private Integer itemTypeUser;
    private List<Integer> itemTypes;
    private Integer actionType;
    private Integer maxRulesPerItem;
    private Boolean doDeltaUpdate;
    private Date lastRun;
    private List<FieldConfiguration> actionFields = new ArrayList<>();
    private List<FieldConfiguration> profileFields = new ArrayList<>();
    private Configuration configuration;

    public AggregatorConfigurationInt() {

    }

    public AggregatorConfigurationInt(Integer tenantId, Integer assocType, List<Integer> itemTypes, Integer actionType, Integer maxRulesPerItem, Boolean doDeltaUpdate, Date lastRun) {
        this.tenantId = tenantId;
        this.assocType = assocType;
        this.itemTypes = itemTypes;
        this.actionType = actionType;
        this.maxRulesPerItem = maxRulesPerItem;
        this.doDeltaUpdate = doDeltaUpdate;
        this.lastRun = lastRun;
        this.configuration = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public Boolean getDoDeltaUpdate() {
        return doDeltaUpdate;
    }

    public void setDoDeltaUpdate(Boolean doDeltaUpdate) {
        this.doDeltaUpdate = doDeltaUpdate;
    }

    public List<Integer> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(List<Integer> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public Integer getMaxRulesPerItem() {
        return maxRulesPerItem;
    }

    public void setMaxRulesPerItem(Integer maxRulesPerItem) {
        this.maxRulesPerItem = maxRulesPerItem;
    }

    public Integer getAssocType() {
        return assocType;
    }

    public void setAssocType(Integer assocType) {
        this.assocType = assocType;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Date getLastRun() {
        return lastRun;
    }

    public void setLastRun(Date lastRun) {
        this.lastRun = lastRun;
    }

    public List<FieldConfiguration> getActionFields() {
        return actionFields;
    }

    public void setActionFields(List<FieldConfiguration> actionFields) {
        this.actionFields = actionFields;
    }

    public List<FieldConfiguration> getProfileFields() {
        return profileFields;
    }

    public void setProfileFields(List<FieldConfiguration> profileFields) {
        this.profileFields = profileFields;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Integer getItemTypeUser() {
        return itemTypeUser;
    }

    public void setItemTypeUser(Integer itemTypeUser) {
        this.itemTypeUser = itemTypeUser;
    }
    
}
