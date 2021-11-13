package com.muhammad.libraryapp.service;


import com.muhammad.libraryapp.model.Book;
import com.muhammad.libraryapp.model.Category;
import com.muhammad.libraryapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private static CategoryRepository categoryRepository;
    @Autowired
    private static BookServiceImpl bookService;

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
        if(!newCategory.isPresent()){
            return false;
        }
        Category c = newCategory.get();
        c.setName(category.getName());
        c.setBooks(category.getBooks());
        categoryRepository.save(c);

        return true;
    }


    @Override
    public void deleteCategory(long id) {
        Category category = categoryRepository.findById(id).get();

        categoryRepository.delete(category);

    }


    @Override
    public Category addBooksToCategory(List<Long> bookIds, long categoryId){
        Category _category = getCategoryById(categoryId);
        if(_category != null){
            List<Book> bookList = _category.getBooks();
            for (Long l : bookIds){
                Book book = bookService.getBookById(l);
                if(book != null){
                    bookList.add(book);
                    }
            }
            _category.setBooks(bookList);
            return categoryRepository.save(_category);
        }

        return  null;


    }
}
