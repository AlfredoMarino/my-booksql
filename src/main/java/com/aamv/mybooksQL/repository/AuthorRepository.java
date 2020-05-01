package com.aamv.mybooksQL.repository;

import com.aamv.mybooksQL.model.Author;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends FirestoreReactiveRepository<Author> {
}
