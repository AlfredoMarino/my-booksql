package com.aamv.MyBooksQL.repository;

import com.aamv.MyBooksQL.model.Book;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends FirestoreReactiveRepository<Book> {
}
