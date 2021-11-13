package com.muhammad.libraryapp.service;

import com.muhammad.libraryapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    Book getBookById(long id);
    Book addBook(Book book);
    boolean updateBook(long id, Book book);
    void deleteBook(long id);
    void addBooksToFavouriteList(List<Long> bookIds);
    List<Book> getFavouriteList();

}
