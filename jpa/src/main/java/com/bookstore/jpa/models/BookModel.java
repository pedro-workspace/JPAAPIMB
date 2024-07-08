package com.bookstore.jpa.models;

import jakarta.persistence.*;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tb_book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorModel> authors = new HashSet<>();

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private ReviewModel review;


    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public PublisherModel getPublisher(){
        return this.publisher;
    }

    public void setPublisher(PublisherModel publisher){
        this.publisher = publisher;
    }

    public Set<AuthorModel> getAuthors(){
        return this.authors;
    }

    public void setAuthors(Set<AuthorModel> authors){
        this.authors = authors;
    }

    public ReviewModel getReview(){
        return this.review;
    }

    public void setReview(ReviewModel review){
        this.review = review;
    }

}
