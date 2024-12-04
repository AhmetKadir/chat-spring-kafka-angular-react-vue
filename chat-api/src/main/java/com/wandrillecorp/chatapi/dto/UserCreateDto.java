package com.wandrillecorp.chatapi.dto;


import jakarta.validation.constraints.NotNull;

public class UserCreateDto {
    @NotNull
    private String name;

    public UserCreateDto() {
    }

    public UserCreateDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
