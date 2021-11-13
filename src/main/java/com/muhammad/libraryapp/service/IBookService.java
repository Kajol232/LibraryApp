package com.muhammad.libraryapp.service;

import com.muhammad.libraryapp.model.Book;
import com.muhammad.libraryapp.model.dtos.BookDTO;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    Book getBookById(long id);
    Book addBook(BookDTO bookDto);
    boolean updateBook(long id, BookDTO bookDto);
    void deleteBook(long id);
    void addBooksToFavouriteList(List<Long> bookIds);
    List<Book> getFavouriteList();

}
