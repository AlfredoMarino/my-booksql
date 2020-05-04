package com.aamv.mybookql.graphql;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.model.Person;
import com.aamv.mybookql.service.AuthorService;
import com.aamv.mybookql.service.BookService;
import com.aamv.mybookql.service.PersonService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Mutation implements GraphQLMutationResolver {

    AuthorService authorService;
    BookService bookService;
    PersonService personService;

    @Autowired
    public Mutation(AuthorService authorService, BookService bookService, PersonService personService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.personService = personService;
    }

    public Author createAuthor(Author author) {
        return authorService.createAuthor(author);
    }
    public Author updateAuthor(String authorId, Author author) {
        return authorService.updateAuthor(authorId, author);
    }
    public String deleteAuthor(String authorId) {
        authorService.deleteAuthor(authorId);
        return authorId;
    }

    public Book createBook(Book book) {
        return bookService.createBook(book);
    }
    public Book updateBook(String bookId, Book book) {
        return bookService.updateBook(bookId, book);
    }
    public String deleteBook(String bookId) {
        bookService.deleteBook(bookId);
        return bookId;
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
