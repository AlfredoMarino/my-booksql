package com.aamv.mybookql.graphql;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.service.AuthorService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    AuthorService authorService;

    @Autowired
    public Mutation(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Author createAuthor(Author author) {
        return authorService.createAuthor(author);
    }

    public Author updateAuthor(String authorId, Author author) {
        System.out.println("aksdjflkasjdfl");
        return authorService.updateAuthor(authorId, author);
    }
}
