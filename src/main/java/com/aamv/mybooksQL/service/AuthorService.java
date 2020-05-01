package com.aamv.mybooksQL.service;

import com.aamv.mybooksQL.model.Author;

import java.util.List;

public interface AuthorService {

    Author createAuthor(Author author);

    Author updateAuthor(String authorId, Author author);

    Author getAuthor(String authorId);

    List<Author> getAuthors();

    void deleteAuthor(String authorId);
}
