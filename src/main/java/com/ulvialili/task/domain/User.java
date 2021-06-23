package com.ulvialili.task.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
