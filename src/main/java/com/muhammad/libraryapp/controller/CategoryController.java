package com.muhammad.libraryapp.controller;

import com.muhammad.libraryapp.model.Category;
import com.muhammad.libraryapp.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);

        return category != null ? new ResponseEntity<>(category, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCategory(@RequestParam String name){
        Category _category = categoryService.addCategory(name);
        return _category != null ? new ResponseEntity<>(_category, HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity updateCategory(@PathVariable Long id, @RequestParam String name){
        return categoryService.updateCategory(id, name) ? new ResponseEntity<> (HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(path = "/addBooks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBooksToCategory(@PathVariable Long id, @RequestParam List<Long> bookIds){
        Category c = categoryService.addBooksToCategory(bookIds, id);

        return c != null ? new ResponseEntity<> (HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }



}
