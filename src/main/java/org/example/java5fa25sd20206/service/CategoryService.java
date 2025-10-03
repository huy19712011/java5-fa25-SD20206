package org.example.java5fa25sd20206.service;

import org.example.java5fa25sd20206.entity.Category;
import org.example.java5fa25sd20206.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }
}
