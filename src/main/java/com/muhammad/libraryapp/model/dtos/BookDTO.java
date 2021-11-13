package com.muhammad.libraryapp.model.dtos;

public class BookDTO {
    private String title;
    private String Author;
    private String description;
    private boolean isFavourite;

    public BookDTO(String title, String author, String description, boolean isFavourite) {
        this.title = title;
        Author = author;
        this.description = description;
        this.isFavourite = isFavourite;
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

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
