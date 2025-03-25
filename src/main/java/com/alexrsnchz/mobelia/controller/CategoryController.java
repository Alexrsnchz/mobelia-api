package com.alexrsnchz.mobelia.controller;

import com.alexrsnchz.mobelia.model.Category;
import com.alexrsnchz.mobelia.model.User;
import com.alexrsnchz.mobelia.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAll();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category) {
        Category categoryToStore = categoryService.store(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryToStore);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody @Valid Category category) {
        Category categoryToUpdate = categoryService.update(id, category);

        return ResponseEntity.ok(categoryToUpdate);
    }


    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
