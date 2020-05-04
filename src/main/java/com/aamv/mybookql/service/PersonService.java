package com.aamv.mybookql.service;

import com.aamv.mybookql.model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(String personId, Person person);

    Person getPerson(String personId);

    List<Person> getPersons();

    void deletePerson(String personId);
}
