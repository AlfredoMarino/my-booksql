package com.aamv.mybookql.service;

import com.aamv.mybookql.model.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book updateBook(String bookId, Book book);

    Book getBook(String bookId);

    List<Book> getBooks();

    List<Book> getBooks(List<String> bookIdentifiers);

    void deleteBook(String bookId);
}
