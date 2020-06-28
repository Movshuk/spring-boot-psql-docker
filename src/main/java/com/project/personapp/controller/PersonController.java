package com.project.personapp.controller;

import com.project.personapp.model.Log;
import com.project.personapp.model.Person;
import com.project.personapp.service.serviceImpl.LogServiceImpl;
import com.project.personapp.service.serviceImpl.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Api request")
public class PersonController {

    final PersonServiceImpl personServiceImpl;

    final LogServiceImpl logServiceImpl;

    public PersonController(PersonServiceImpl personServiceImpl, LogServiceImpl logServiceImpl) {
        this.personServiceImpl = personServiceImpl;
        this.logServiceImpl = logServiceImpl;
    }

    @CrossOrigin
    @ApiOperation(value = "Get all persons",
            produces="application/json",
            consumes="application/json")
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPersons(HttpServletRequest request) {

        try {
            List<Person> list = personServiceImpl.findAll();
            Log log = logServiceImpl.makingLog(request);
            logServiceImpl.save(log);

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @CrossOrigin
    @ApiOperation(value = "Add person",
            produces="application/json",
            consumes="application/json")
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@RequestBody Person person, HttpServletRequest request) {

        person.setId(null); //it is new person, auto incrementation

        try {
            Person responsePerson = personServiceImpl.save(person);
            Log log = logServiceImpl.makingLog(request, person);
            logServiceImpl.save(log);

            return new ResponseEntity<>(responsePerson, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

    }



}
