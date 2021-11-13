package com.muhammad.libraryapp.service;

import com.muhammad.libraryapp.model.Book;
import com.muhammad.libraryapp.model.dtos.BookDTO;
import com.muhammad.libraryapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        return bookRepository.save(setBook(book, bookDTO));
    }

    @Override
    public boolean updateBook(long id, BookDTO bookDTO) {
        Optional<Book> newBook = bookRepository.findById(id);
        if(!newBook.isPresent()){
            return false;
        }
        Book b = setBook(newBook.get(), bookDTO);
        bookRepository.save(b);
        return true;


    }

    @Override
    public void deleteBook(long id) {
        Book book = bookRepository.findById(id).get();

        bookRepository.delete(book);

    }
    @Override
    public void addBooksToFavouriteList(List<Long> bookIds){
        for(Long l : bookIds){
            Book book = getBookById(l);
            if(book != null){
                book.setFavourite(true);
                bookRepository.save(book);
            }
        }
    }

    @Override
    public List<Book> getFavouriteList(){
        return bookRepository.findAllByIsFavouriteIsTrue();
    }

    private Book setBook(Book book, BookDTO bookDTO){
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setFavourite(bookDTO.isFavourite());
        return book;

    }
}
