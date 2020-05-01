package com.aamv.mybooksQL.service;

import com.aamv.mybooksQL.model.Author;
import com.aamv.mybooksQL.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author).block();
    }

    @Override
    public Author updateAuthor(String authorId, Author author) {
        Author persistedAuthor = getAuthor(authorId);
        persistedAuthor.setName(author.getName());
        return authorRepository.save(persistedAuthor).block();
    }

    @Override
    public Author getAuthor(String authorId) {
        return authorRepository.findById(authorId).block();
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll().collectList().block();
    }

    @Override
    public void deleteAuthor(String authorId) {
        authorRepository.deleteById(authorId).block();
    }
}
