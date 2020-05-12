package com.aamv.mybookql.graphql.query;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.service.AuthorService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorQuery implements GraphQLQueryResolver {

    AuthorService authorService;

    @Autowired
    public AuthorQuery(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    public Author getAuthor(String authorId) {
        return authorService.getAuthor(authorId);
    }
}
