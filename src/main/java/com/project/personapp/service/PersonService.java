package com.project.personapp.service;

import com.project.personapp.model.Person;

import java.util.List;

public interface PersonService {

    boolean existsById(Long id);
    Person save(Person person);
    List<Person> findAll();
    Person findById(Long id);

}
