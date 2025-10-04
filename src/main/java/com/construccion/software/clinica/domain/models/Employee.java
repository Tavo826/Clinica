package com.construccion.software.clinica.domain.models;

import com.construccion.software.clinica.domain.models.enums.Role;

public class Employee extends Person {

    private Role role;
    private String username;
    private String password;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
