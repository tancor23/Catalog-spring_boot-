package com.itrexgroup.skeleton.to;

public enum Role {
    USER("user"),
    ADMIN("admin"),
    DEVELOPER("developer");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }
}
