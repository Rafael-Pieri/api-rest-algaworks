package com.algaworks.socialbooks.dto.book;

import com.algaworks.socialbooks.dto.author.AuthorDTO;
import com.algaworks.socialbooks.model.book.Comment;

import java.util.Date;
import java.util.List;

public class BookDTO {

    private Long id;
    private String name;
    private Date publication;
    private String publisher;
    private String summary;
    private List<Comment> comments;
    private AuthorDTO author;

    public BookDTO() {

    }

    public BookDTO(Long id, String name, Date publication, String publisher, String summary, List<Comment> comments, AuthorDTO author) {
        this.id = id;
        this.name = name;
        this.publication = publication;
        this.publisher = publisher;
        this.summary = summary;
        this.comments = comments;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}