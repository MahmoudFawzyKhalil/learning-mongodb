package com.example.learning_mongodb.dto;

import com.example.learning_mongodb.model.Person;

public record CreatePersonRequest(String firstName, String lastName) {
    // Mapping
    public Person toModel() {
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
