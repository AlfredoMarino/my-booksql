package com.aamv.mybookql.model;

import com.google.cloud.firestore.annotation.DocumentId;

import java.util.List;

public class Person {

    @DocumentId
    private String id;
    private String name;
    private String surname;
    private List<String> bookIdentifiers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getBookIdentifiers() {
        return bookIdentifiers;
    }

    public void setBookIdentifiers(List<String> bookIdentifiers) {
        this.bookIdentifiers = bookIdentifiers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bookIdentifiers=" + bookIdentifiers +
                '}';
    }
}
