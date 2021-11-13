package com.muhammad.libraryapp.controller;

import com.muhammad.libraryapp.model.Book;
import com.muhammad.libraryapp.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private static BookServiceImpl bookService;

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book book = bookService.getBookById(id);

        return book != null ? new ResponseEntity<>(book, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping (path = "/add")
    public ResponseEntity addBook(@RequestBody Book book){
        Book _book = bookService.addBook(book);
        return _book != null ? new ResponseEntity<>(_book, HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @PostMapping (path = "/update/{id}")
    public ResponseEntity updateBook(@PathVariable long id, @RequestBody Book book){
        return bookService.updateBook(id, book)? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
