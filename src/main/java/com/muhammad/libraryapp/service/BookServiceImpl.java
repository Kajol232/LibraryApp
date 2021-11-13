package com.muhammad.libraryapp.service;

import com.muhammad.libraryapp.model.Book;
import com.muhammad.libraryapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements IBookService{
    @Autowired
    private static BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean updateBook(long id, Book book) {
        Optional<Book> newBook = bookRepository.findById(id);
        if(!newBook.isPresent()){
            return false;
        }
        Book b = newBook.get();
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        b.setCategories(book.getCategories());
        bookRepository.save(b);
        return true;


    }

    @Override
    public boolean deleteBook(long id) {
        Optional<Book> newBook = bookRepository.findById(id);
        if(!newBook.isPresent()){
            return false;
        }
        bookRepository.delete(newBook.get());
        return true;

    }
}
