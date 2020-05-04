package com.aamv.mybookql.repository;

import com.aamv.mybookql.model.Person;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends FirestoreReactiveRepository<Person> {
}
