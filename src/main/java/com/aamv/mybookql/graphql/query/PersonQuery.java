package com.aamv.mybookql.graphql.query;

import com.aamv.mybookql.model.Person;
import com.aamv.mybookql.service.PersonService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonQuery implements GraphQLQueryResolver {

    PersonService personService;

    @Autowired
    public PersonQuery(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> getPersons() {
        return personService.getPersons();
    }

    public Person getPerson(String personId) {
        return personService.getPerson(personId);
    }
}
