package com.bookstore.jpa.models;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "TB_REVIEW")
public class ReviewModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String comment;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public BookModel getBook(){
        return this.book;
    }

    public void setBook(BookModel book){
        this.book = book;
    }

}
