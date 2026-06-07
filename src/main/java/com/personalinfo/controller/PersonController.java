package com.personalinfo.controller;

import com.personalinfo.entity.PersonalInfo;
import com.personalinfo.service.PersonService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonalInfo> createPerson(@RequestBody PersonalInfo person) {
        log.info("Application Started TO save the Personal Information");
        PersonalInfo savedPerson = personService.savePerson(person);
        log.info("Suucessfuly stored the personal information");
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonalInfo>> getAllPersons() {
        List<PersonalInfo> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInfo> getPersonById(@PathVariable Long id) {
        Optional<PersonalInfo> person = personService.getPersonById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PersonalInfo> getPersonByEmail(@PathVariable String email) {
        Optional<PersonalInfo> person = personService.getPersonByEmail(email);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfo> updatePerson(@PathVariable Long id, @RequestBody PersonalInfo personDetails) {
        PersonalInfo updatedPerson = personService.updatePerson(id, personDetails);
        if (updatedPerson != null) {
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean deleted = personService.deletePerson(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
