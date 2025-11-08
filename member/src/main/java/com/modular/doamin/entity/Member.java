package com.modular.doamin.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Member {
    private final String id;
    private final String name;
    private final String email;

    public Member(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }
}
