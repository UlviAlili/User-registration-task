package com.ulvialili.task.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private List<Role> roles;
}
