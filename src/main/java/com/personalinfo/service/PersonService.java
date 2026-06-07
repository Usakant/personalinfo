package com.personalinfo.service;

import com.personalinfo.entity.PersonalInfo;
import com.personalinfo.exception.PersonalInfoAllReadyExistException;
import com.personalinfo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    public PersonalInfo savePerson(PersonalInfo person) {
        Optional<PersonalInfo> response = personRepository.findById(person.getId());
        if(!response.isPresent()){
            return personRepository.save(person);
        }else{
            throw new PersonalInfoAllReadyExistException("person details exist");
        }
    }

    public List<PersonalInfo> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<PersonalInfo> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Optional<PersonalInfo> getPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public PersonalInfo updatePerson(Long id, PersonalInfo personDetails) {
        Optional<PersonalInfo> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            PersonalInfo person = optionalPerson.get();
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
