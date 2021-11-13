package com.muhammad.libraryapp.model;

import com.sun.istack.Nullable;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Nullable
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "categories_books",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    @CreationTimestamp
    private LocalDateTime creationDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    public Category(){}

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public LocalDateTime getLastUpdatedDate() {
        return dateLastModified;
    }
}
