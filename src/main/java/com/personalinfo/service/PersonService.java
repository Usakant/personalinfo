package com.personalinfo.service;

import com.personalinfo.entity.Person;
import com.personalinfo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Optional<Person> getPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setEmail(personDetails.getEmail());
            person.setPhoneNumber(personDetails.getPhoneNumber());
            person.setAddress(personDetails.getAddress());
            person.setCity(personDetails.getCity());
            person.setState(personDetails.getState());
            person.setZipCode(personDetails.getZipCode());
            return personRepository.save(person);
        }
        return null;
    }

    public boolean deletePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
