package com.aamv.MyBooksQL.repository;

import com.aamv.MyBooksQL.model.Author;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends FirestoreReactiveRepository<Author> {
}
