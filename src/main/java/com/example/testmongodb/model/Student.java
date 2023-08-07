package com.example.testmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;

    public Student(String firstName,
                   String lastName,
                   String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}