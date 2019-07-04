package com.globant.bootcamp.airlines.controllers;


import com.globant.bootcamp.airlines.domain.Person;
import com.globant.bootcamp.airlines.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ControllerPerson {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping()
    public List<Person> getPersons(){return personRepository.findAll();};

    @GetMapping("{numDocument}")
    public Person getPersonByNumDocument(@PathVariable (value="numDocument") String numDocument){
        return personRepository.findByNumDocument(numDocument);
    }

    @PostMapping()
    public ResponseEntity addPerson(@RequestBody Person p){
        if (personRepository.findByNumDocument(p.getNumDocument()) == null ){
            personRepository.save(p);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(p);
    }
}
