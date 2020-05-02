package com.aamv.mybookql.service;

import com.aamv.mybookql.model.Author;

import java.util.List;

public interface AuthorService {

    Author createAuthor(Author author);

    Author updateAuthor(String authorId, Author author);

    Author getAuthor(String authorId);

    List<Author> getAuthors();

    void deleteAuthor(String authorId);
}
