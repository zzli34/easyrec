/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.easyrec.plugin.aggregator.store.dao.impl;

import java.net.URI;
import java.sql.Types;
import java.util.Date;
import javax.sql.DataSource;
import org.easyrec.plugin.aggregator.store.dao.AggregatorLogEntryDAO;
import org.easyrec.plugin.model.Version;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Stephan
 */
public class AggregatorLogEntryDAOImpl extends JdbcDaoSupport implements AggregatorLogEntryDAO {

    public AggregatorLogEntryDAOImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }
    
    
    @Override
    public Date getLastLogEntryForTenant(int tenantId, int assocTypeId, URI pluginID, Version version) {
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT MAX(startDate) FROM plugin_log WHERE tenantId=? AND pluginId=? AND pluginVersion=? AND assocTypeId=? AND endDate IS NOT NULL");
        Object[] args = {tenantId, pluginID.toString(), version.toString(), assocTypeId};
        int[] argt = {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};

        return getJdbcTemplate().queryForObject(query.toString(), args, argt, Date.class);
    }
    
    
    
    
}
