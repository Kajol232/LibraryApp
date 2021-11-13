package com.muhammad.libraryapp.service;

import com.muhammad.libraryapp.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategories();
    Category getCategoryById(long id);
    Category addCategory(String name);
    boolean updateCategory(long id, String name);
    void deleteCategory(long id);
    Category addBooksToCategory(List<Long> bookIds, long categoryId);
}
