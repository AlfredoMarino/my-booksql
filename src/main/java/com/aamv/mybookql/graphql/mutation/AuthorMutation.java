package com.aamv.mybookql.graphql.mutation;

import com.aamv.mybookql.model.Author;
import com.aamv.mybookql.service.AuthorService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation implements GraphQLMutationResolver {

    AuthorService authorService;

    @Autowired
    public AuthorMutation(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Author createAuthor(Author author) {
        return authorService.createAuthor(author);
    }
    public Author updateAuthor(String authorId, Author author) {
        return authorService.updateAuthor(authorId, author);
    }
    public String deleteAuthor(String authorId) {
        authorService.deleteAuthor(authorId);
        return authorId;
    }
}
