package com.muhammad.libraryapp.controller;

import com.muhammad.libraryapp.model.Category;
import com.muhammad.libraryapp.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private static CategoryServiceImpl categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);

        return category != null ? new ResponseEntity<>(category, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/add")
    public ResponseEntity addBook(@RequestBody Category category){
        Category _category = categoryService.addCategory(category);
        return _category != null ? new ResponseEntity<>(_category, HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = "/update/{id}" )
    public ResponseEntity updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryService.updateCategory(id, category) ? new ResponseEntity<> (HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(path = "/addBooks/{id}")
    public ResponseEntity addBooksToCategory(@PathVariable Long id, @RequestParam List<Long> bookIds){
        Category c = categoryService.addBooksToCategory(bookIds, id);

        return c != null ? new ResponseEntity<> (HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }



}
