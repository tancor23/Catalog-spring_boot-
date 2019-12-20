package com.itrexgroup.skeleton.to;

public enum Status {
    ACTIVE("active"),
    INACTIVE("inactive"),
    EXPIRED("expired"),
    STOPPED("stopped");

    private String status;

    Status(String status){
        this.status = status;
    }

    public String getValue(){
        return status;
    }
}
