/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.easyrec.plugin.aggregator.store.dao;

import java.net.URI;
import java.util.Date;
import org.easyrec.plugin.model.Version;

/**
 *
 * @author Stephan
 */
public interface AggregatorLogEntryDAO {
    public Date getLastLogEntryForTenant(int tenantId, int assocTypeId, URI pluginID, Version version);
}
