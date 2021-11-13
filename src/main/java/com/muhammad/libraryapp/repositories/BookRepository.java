package com.muhammad.libraryapp.repositories;

import com.muhammad.libraryapp.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findAllByIsFavouriteIsTrue();

}
