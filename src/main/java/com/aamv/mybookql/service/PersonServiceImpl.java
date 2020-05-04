package com.aamv.mybookql.service;

import com.aamv.mybookql.model.Person;
import com.aamv.mybookql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        person.setId(UUID.randomUUID().toString());
        return personRepository.save(person).block();
    }

    @Override
    public Person updatePerson(String personId, Person person) {
        Person persistedPerson = getPerson(personId);
        persistedPerson.setName(person.getName());
        persistedPerson.setSurname(person.getSurname());
        return personRepository.save(persistedPerson).block();
    }

    @Override
    public Person getPerson(String personId) {
        return personRepository.findById(personId).block();
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll().collectList().block();
    }

    @Override
    public void deletePerson(String personId) {
        personRepository.deleteById(personId);
    }
}
