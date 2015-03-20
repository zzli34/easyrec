/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.easyrec.plugin.aggregator.model;

import com.jayway.jsonpath.JsonPath;

/**
 *
 * @author Stephan
 */
public class FieldConfiguration {
    
    private String outputField;
    private JsonPath jsonPath;
    private Integer itemType;

    public FieldConfiguration(String outputField, JsonPath jsonPath) {
        this.outputField = outputField;
        this.jsonPath = jsonPath;
    }
    
    public String getOutputField() {
        return outputField;
    }

    public void setOutputField(String outputField) {
        this.outputField = outputField;
    }

    public JsonPath getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(JsonPath jsonPath) {
        this.jsonPath = jsonPath;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }
    
}
