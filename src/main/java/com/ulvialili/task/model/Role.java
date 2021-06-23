package com.ulvialili.task.model;

public enum Role {
    USER(1),
    ADMIN(2);

    private int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

//    public static Role from(int id) {
//        return Arrays.stream(values())
//                .filter(role -> role.id == id)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Role not found for id " + id));
//    }
}
