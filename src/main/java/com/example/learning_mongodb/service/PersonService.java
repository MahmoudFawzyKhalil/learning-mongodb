package com.example.learning_mongodb.service;

import com.example.learning_mongodb.model.Person;
import com.example.learning_mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// PersonService
// PersonCreationService
// PersonFetchingService
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person createPerson(Person person) {
        validatePerson(person);
        return personRepository.save(person);
    }

    private void validatePerson(Person person) {
        validateName(person.firstName());
        validateName(person.lastName());
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
