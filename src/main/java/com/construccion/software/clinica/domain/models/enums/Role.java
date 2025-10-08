package com.construccion.software.clinica.domain.models.enums;

public enum Role {
    DOCTOR("Doctor"),
    NURSE("Nurse"),
    HUMAN_RESOURCE("Human Resource"),
    ADMINISTRATIVE("Administrative"),
    INFORMATION_SUPPORT("Information Support");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public static boolean containsRoleName(String roleName) {
        boolean result = false;
        for (Role role : Role.values()) {
            result = role.name().equalsIgnoreCase(roleName);
        }

        return result;
    }
}
