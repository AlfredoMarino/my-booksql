package com.aamv.mybookql.graphql.mutation;

import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.service.BookService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    BookService bookService;

    @Autowired
    public BookMutation(BookService bookService) {
        this.bookService = bookService;
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

}
