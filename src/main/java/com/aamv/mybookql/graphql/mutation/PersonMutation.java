package com.aamv.mybookql.graphql.mutation;

import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.model.Person;
import com.aamv.mybookql.service.BookService;
import com.aamv.mybookql.service.PersonService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonMutation implements GraphQLMutationResolver {

    BookService bookService;
    PersonService personService;

    @Autowired
    public PersonMutation(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    public Person createPerson(Person person) {
        return personService.createPerson(person);
    }
    public Person updatePerson(String personId, Person person) {
        return personService.updatePerson(personId, person);
    }
    public String deletePerson(String personId) {
        personService.deletePerson(personId);
        return personId;
    }

    public Person readBook(String personId, String bookId) {
        Person person = personService.getPerson(personId);
        Book book = bookService.getBook(bookId);
        if (person.getBookIdentifiers() == null) {
            person.setBookIdentifiers(new ArrayList<>());
        }
        person.getBookIdentifiers().add(book.getId());
        return personService.updatePerson(personId, person);
    }
}
