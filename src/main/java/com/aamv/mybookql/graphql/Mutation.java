package com.aamv.mybookql.graphql;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.service.AuthorService;
import com.aamv.mybookql.service.BookService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    AuthorService authorService;
    BookService bookService;

    @Autowired
    public Mutation(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
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
        System.out.println(bookId + book);
        return bookService.updateBook(bookId, book);
    }

    public String deleteBook(String bookId) {
        bookService.deleteBook(bookId);
        return bookId;
    }
}
