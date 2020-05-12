package com.aamv.mybookql.graphql.query;

import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.service.BookService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQuery implements GraphQLQueryResolver {

    BookService bookService;

    @Autowired
    public BookQuery(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    public Book getBook(String bookId) {
        return bookService.getBook(bookId);
    }
}
