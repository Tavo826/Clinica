package com.construccion.software.clinica.domain.models;

import com.construccion.software.clinica.domain.models.enums.Role;

import java.util.Date;

public class Employee {

    private long id;
    private String name;
    private long documentId;
    private String email;
    private String phone;
    private Date birthDate;
    private String address;
    private Role role;
    private String username;
    private String password;
}
