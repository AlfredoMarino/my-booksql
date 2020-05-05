package com.aamv.mybookql.service.impl;

import com.aamv.mybookql.model.Book;
import com.aamv.mybookql.repository.BookRepository;
import com.aamv.mybookql.service.AuthorService;
import com.aamv.mybookql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public Book createBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        book.setAuthors(authorService.createAuthors(book.getAuthors()));
        return bookRepository.save(book).block();
    }

    @Override
    public Book updateBook(String bookId, Book book) {
        Book persistedBook = getBook(bookId);
        if (book.getTitle() != null) persistedBook.setTitle(book.getTitle());
        if (book.getSubtitle() != null) persistedBook.setSubtitle(book.getSubtitle());
        if (book.getSynopsis() != null) persistedBook.setSynopsis(book.getSynopsis());
        if (book.getAuthors() != null) persistedBook.setAuthors(book.getAuthors());
        if (book.getPublicationDate() != null) persistedBook.setPublicationDate(book.getPublicationDate());
        if (book.getCategories() != null) persistedBook.setCategories(book.getCategories());
        if (book.getIsbn10() != null) persistedBook.setIsbn10(book.getIsbn10());
        if (book.getIsbn13() != null) persistedBook.setIsbn13(book.getIsbn13());
        if (book.getIdGoogle() != null) persistedBook.setIdGoogle(book.getIdGoogle());
        return bookRepository.save(persistedBook).block();
    }

    @Override
    public Book getBook(String bookId) {
        return bookRepository.findById(bookId).block();
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll().collectList().block();
    }

    @Override
    public List<Book> getBooks(List<String> bookIdentifiers) {
        return bookRepository.findAllById(bookIdentifiers).collectList().block();
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId).block();
    }
}
