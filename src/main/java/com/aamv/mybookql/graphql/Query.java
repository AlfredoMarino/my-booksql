package com.aamv.mybookql.graphql;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.service.AuthorService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    AuthorService authorService;

    @Autowired
    public Query(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }
}
