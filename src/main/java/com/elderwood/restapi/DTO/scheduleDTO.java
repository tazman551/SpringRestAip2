package com.elderwood.restapi.DTO;

import java.util.Set;

import com.elderwood.restapi.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class scheduleDTO {

    
    tables table;
    Set<Object> res;
    
    public scheduleDTO(tables t, Set<Object> res) {
        this.table = t;
        this.res = res;
    }

    public tables getTable() {
        return table;
    }

    public void setTable(tables table) {
        this.table = table;
    }

    public Set<Object> getRes() {
        return res;
    }

    public void setRes(Set<Object> res) {
        this.res = res;
    }

    
}
