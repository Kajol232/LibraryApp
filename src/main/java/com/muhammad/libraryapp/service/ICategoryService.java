package com.muhammad.libraryapp.service;

import com.muhammad.libraryapp.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategories();
    Category getCategoryById(long id);
    Category addCategory(Category category);
    boolean updateCategory(long id, Category category);
    void deleteCategory(long id);
    Category addBooksToCategory(List<Long> bookIds, long categoryId);
}
