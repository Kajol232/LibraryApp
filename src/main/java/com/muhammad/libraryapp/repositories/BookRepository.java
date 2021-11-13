package com.muhammad.libraryapp.repositories;

import com.muhammad.libraryapp.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findAllByFavouriteIsTrue();

}
