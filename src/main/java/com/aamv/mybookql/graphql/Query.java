package com.aamv.mybookql.graphql;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.service.AuthorService;
import com.aamv.mybookql.service.BookService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    AuthorService authorService;
    BookService bookService;

    @Autowired
    public Query(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
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
}
