package com.nalumeya.CrudOperation.service;

import com.nalumeya.CrudOperation.model.PersonEntity;
import com.nalumeya.CrudOperation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public String createPerson(PersonEntity person)
    {
       personRepository.save(person);
       return ""+person.getId();
    }

    public List<PersonEntity> getPersons()
    {
        return personRepository.findAll();
    }

    public String getPersonById(int id)
    {
        return "Person with id:"+personRepository.findById(id);
    }

    public String updatePerson(PersonEntity updatedPerson, int id)
    {
        Optional<PersonEntity>existingPerson=personRepository.findById(id);
        if(existingPerson.isPresent())
        {
            PersonEntity person=existingPerson.get();
            person.setFirstName(updatedPerson.getFirstName());
            person.setLastName(updatedPerson.getLastName());
            person.setAge(updatedPerson.getAge());
            person.setEmail(updatedPerson.getEmail());
            person.setAddress(updatedPerson.getAddress());
            personRepository.save(person);
            return "Updated person record with id: "+id+"is "+person;
        }
        else {
            return "No required data present in db ";
        }
    }

    public String deletePerson(int id)
    {
        personRepository.deleteById(id);
        return "Person with id: "+id+" is deleted";
    }
}
