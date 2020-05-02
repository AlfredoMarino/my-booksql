package com.aamv.mybookql.service;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        author.setId(UUID.randomUUID().toString());
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
