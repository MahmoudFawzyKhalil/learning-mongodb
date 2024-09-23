package com.example.learning_mongodb.dto;

import com.example.learning_mongodb.model.Person;

public record ObjectIdResponse(String id) {
    // Mapping
    // static factory method
    public static ObjectIdResponse fromPerson(Person person) {
        return new ObjectIdResponse(person.id());
    }

}

class ObjectIdResponseCreator {

}
