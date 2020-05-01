package com.aamv.MyBooksQL.model;

import com.google.cloud.firestore.annotation.DocumentId;

public class Author {

    @DocumentId
    private String id;
    private String Name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
