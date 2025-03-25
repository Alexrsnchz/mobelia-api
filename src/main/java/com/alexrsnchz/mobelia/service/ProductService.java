package com.alexrsnchz.mobelia.service;

import com.alexrsnchz.mobelia.exception.ProductAlreadyExistsException;
import com.alexrsnchz.mobelia.model.Product;
import com.alexrsnchz.mobelia.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public Product store(Product product) {
        if (productRepository.existsByName(product.getName())) {
            throw new ProductAlreadyExistsException("That product already exists");
        }

        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Product productToUpdate = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));

        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setImage(product.getImage());
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setStyle(product.getStyle());
        productToUpdate.setMaterial(product.getMaterial());
        productToUpdate.setColor(product.getColor());
        productToUpdate.setHeight(product.getHeight());
        productToUpdate.setWidth(product.getWidth());
        productToUpdate.setDepth(product.getDepth());
        productToUpdate.setWeight(product.getWeight());

        return productRepository.save(productToUpdate);
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found");
        }

        productRepository.deleteById(id);
    }

}
