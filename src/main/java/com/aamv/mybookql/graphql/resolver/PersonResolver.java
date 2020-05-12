package com.aamv.mybookql.graphql.resolver;

import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.model.Person;
import com.aamv.mybookql.service.BookService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonResolver implements GraphQLResolver<Person> {

    private BookService bookService;

    @Autowired
    public PersonResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getBooksRead(Person person) {
        return bookService.getBooks(person.getBookIdentifiers());
    }

}
