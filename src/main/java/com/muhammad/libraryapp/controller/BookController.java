package com.muhammad.libraryapp.controller;

import com.muhammad.libraryapp.model.Book;
import com.muhammad.libraryapp.model.dtos.BookDTO;
import com.muhammad.libraryapp.model.dtos.UpdateDTO;
import com.muhammad.libraryapp.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book book = bookService.getBookById(id);

        return book != null ? new ResponseEntity<>(book, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @GetMapping(path = "/getFavourites", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getFavourites(){
        List<Book> favList = bookService.getFavouriteList();

        return favList.size() > 0 ? new ResponseEntity<>(favList, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }
    @PostMapping (path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBook(@RequestBody BookDTO bookDTO){
        Book _book = bookService.addBook(bookDTO);
        return _book != null ? new ResponseEntity<>(_book, HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @PutMapping (path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        return bookService.updateBook(id, bookDTO)? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/addToFavourites", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> addToFavourite(@RequestParam List<Long> bookIds){
        bookService.addBooksToFavouriteList(bookIds);
        return new ResponseEntity<>( HttpStatus.OK);


    }
}
