package com.project.personapp.service.serviceImpl;

import com.project.personapp.model.Person;
import com.project.personapp.repository.PersonRepository;
import com.project.personapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public boolean existsById(Long id) {
        return personRepository.existsById(id);
    }

    public Person save(Person person) {
        if (person.getId() != null && existsById(person.getId())) {
            return null;
        }
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

}
