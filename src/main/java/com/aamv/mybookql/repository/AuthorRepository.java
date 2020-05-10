package com.aamv.mybookql.repository;

import com.aamv.mybookql.model.Author;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends FirestoreReactiveRepository<Author> {

    Mono<Author> findByName(String name);
}
