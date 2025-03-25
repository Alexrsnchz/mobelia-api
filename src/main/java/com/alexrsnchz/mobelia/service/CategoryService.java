package com.alexrsnchz.mobelia.service;

import com.alexrsnchz.mobelia.exception.CategoryAlreadyExistsException;
import com.alexrsnchz.mobelia.model.Category;
import com.alexrsnchz.mobelia.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public Category store(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException("That category already exists");
        }

        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));

        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setProducts(category.getProducts());

        return categoryRepository.save(categoryToUpdate);
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category not found");
        }

        categoryRepository.deleteById(id);
    }

}
