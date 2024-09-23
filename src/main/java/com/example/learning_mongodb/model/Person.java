package com.example.learning_mongodb.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

// Person -> "person", "person_collection"
@Document("person")
@Builder
public record Person(
        String id,
        /*@Field("firstName") */String firstName, // first_name
        String lastName,
        String favoriteColor
) {
}
