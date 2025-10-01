package org.example.java5fa25sd20206.service;

import org.example.java5fa25sd20206.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
