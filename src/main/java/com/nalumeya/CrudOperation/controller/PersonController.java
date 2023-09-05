package com.nalumeya.CrudOperation.controller;

import com.nalumeya.CrudOperation.model.PersonEntity;
import com.nalumeya.CrudOperation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("person")
    public String createPerson(@RequestBody PersonEntity person)
    {
        personService.createPerson(person);
        return "Person record was created with id:"+person.getId();
    }

    @GetMapping("person")
    public List<PersonEntity> getPersons()
    {
        return personService.getPersons();
    }

    @GetMapping("person/{id}")
    public String getPersonById(@PathVariable int id)
    {
        return personService.getPersonById(id);
    }

    @PutMapping("person/{id}")
    public String updatePerson(@RequestBody PersonEntity updatedPerson, @PathVariable int id)
    {
        return personService.updatePerson(updatedPerson,id);
    }

    @DeleteMapping("person/{id}")
    public String deletePerson(@PathVariable int id)
    {
        return personService.deletePerson(id);
    }

}
