package com.aamv.mybookql.graphql;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.model.Person;
import com.aamv.mybookql.service.AuthorService;
import com.aamv.mybookql.service.BookService;
import com.aamv.mybookql.service.PersonService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    AuthorService authorService;
    BookService bookService;
    PersonService personService;

    @Autowired
    public Query(AuthorService authorService, BookService bookService, PersonService personService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.personService = personService;
    }

    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    public Author getAuthor(String authorId) {
        return authorService.getAuthor(authorId);
    }

    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    public Book getBook(String bookId) {
        return bookService.getBook(bookId);
    }

    public List<Person> getPersons() {
        return personService.getPersons();
    }

    public Person getPerson(String personId) {
        return personService.getPerson(personId);
    }
}
