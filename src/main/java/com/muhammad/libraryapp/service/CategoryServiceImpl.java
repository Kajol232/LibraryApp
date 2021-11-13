package com.muhammad.libraryapp.service;


import com.muhammad.libraryapp.model.Book;
import com.muhammad.libraryapp.model.Category;
import com.muhammad.libraryapp.model.dtos.CategoryDTO;
import com.muhammad.libraryapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{
    private final CategoryRepository categoryRepository;
    private final BookServiceImpl bookService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, BookServiceImpl bookService) {
        this.categoryRepository = categoryRepository;
        this.bookService = bookService;
    }

    @Override
    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category addCategory(String name) {

        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public boolean updateCategory(long id, String name) {
        Optional<Category> newCategory = categoryRepository.findById(id);
        if(!newCategory.isPresent()){
            return false;
        }
        Category c = newCategory.get();
        c.setName(name);
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
