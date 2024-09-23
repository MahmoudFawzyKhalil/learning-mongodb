package com.example.learning_mongodb.repository;

import com.example.learning_mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Makes this a Spring bean, so we can dependency inject into other beans
public interface PersonRepository extends MongoRepository<Person, String> {
    // Two ways of writing queries
    // @Query

    @Query("{firstName: ?0}")
    List<Person> findPeopleByTheirFirstName(String firstName);

    // Method name queries
    List<Person> findByFirstName(String firstName);
}

//interface A {
//    void someMethod();
//}
//
//interface B extends A {
//
//}
//
//class C implements B {
//
//    @Override
//    public void someMethod() {
//
//    }
//}