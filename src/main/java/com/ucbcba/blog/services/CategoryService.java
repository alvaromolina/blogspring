package com.ucbcba.blog.services;

import com.ucbcba.blog.entities.Category;

public interface CategoryService {

    Iterable<Category> listAllCategories();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);

}