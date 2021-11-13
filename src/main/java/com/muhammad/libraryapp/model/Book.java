package com.muhammad.libraryapp.model;

import com.sun.istack.Nullable;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String Author;
    private String description;
    private boolean isFavourite;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    public Book(){}

    public Book(String title, String author, String description, boolean isFavourite) {
        this.title = title;
        Author = author;
        this.description = description;
        this.isFavourite = isFavourite;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public LocalDateTime getLastUpdatedDate() {
        return dateLastModified;
    }
}
