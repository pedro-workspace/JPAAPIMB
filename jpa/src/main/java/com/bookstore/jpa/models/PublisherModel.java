package com.bookstore.jpa.models;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util. UUID;
import java.util.Set;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_PUBLISHER")
public class PublisherModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private Set<BookModel> books = new HashSet<>();

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<BookModel> getBooks(){
        return this.books;
    }

    public void setBooks(Set<BookModel> books){
        this.books = books;
    }

}
