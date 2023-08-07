package com.example.testmongodb.model;

import lombok.Builder;

public record StudentDto(String id, String firstName, String lastName, String email) {
    @Builder
    public StudentDto {
    }
}
