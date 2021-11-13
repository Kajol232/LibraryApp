package com.muhammad.libraryapp.repositories;

import com.muhammad.libraryapp.model.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {
}
