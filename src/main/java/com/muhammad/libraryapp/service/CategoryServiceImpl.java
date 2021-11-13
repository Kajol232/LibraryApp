package com.muhammad.libraryapp.service;


import com.muhammad.libraryapp.model.Category;
import com.muhammad.libraryapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private static CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean updateCategory(long id, Category category) {
        Optional<Category> newCategory = categoryRepository.findById(id);
            if(!newCategory.isPresent()){return false;}
             Category
        }

    }

    @Override
    public void deleteCategory(long id) {

    }
}
