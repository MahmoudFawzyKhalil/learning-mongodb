package com.example.learning_mongodb.controller;

import com.example.learning_mongodb.model.Person;
import com.example.learning_mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    // GET /people
    @GetMapping
    public List<Person> findAll(@RequestParam("firstName") String firstName) {
        if (firstName == null) {
            return personRepository.findAll();
        }
        List<Person> peopleByFirstName = personRepository.findByFirstName(firstName);
        return peopleByFirstName;
    }

    // POST /people
    @PostMapping
    public Person save(@RequestBody Person person) {
        Person saved = personRepository.save(person);
        return saved;
    }

    // GET /people/{id}
    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) {
        Person person = personRepository.findById(id)
                .orElse(null);
        return person;
    }
}
