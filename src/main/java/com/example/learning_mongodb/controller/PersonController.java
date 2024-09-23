package com.example.learning_mongodb.controller;

import com.example.learning_mongodb.dto.CreatePersonRequest;
import com.example.learning_mongodb.dto.ObjectIdResponse;
import com.example.learning_mongodb.model.Person;
import com.example.learning_mongodb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    // POST /people
    @PostMapping
    public ObjectIdResponse save(@RequestBody CreatePersonRequest request) {
        Person person = personService.createPerson(request.toModel());
//        return new ObjectIdResponse(person.id());
        return ObjectIdResponse.fromPerson(person);
    }
}
