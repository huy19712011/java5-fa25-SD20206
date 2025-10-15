package org.example.java5fa25sd20206.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java5fa25sd20206.entity.Product;
import org.example.java5fa25sd20206.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public void saveProduct(@Valid Product product) {

        productRepository.save(product);
    }

    public void deleteProductById(long id) {

        productRepository.deleteById(id);
    }

    public Product getProductById(long id) {

        return productRepository.findById(id).get();
    }

    public void updateProduct(@Valid Product product) {

        productRepository.save(product);
    }

    public List<Product> searchProductsByName(String keyword) {

        return productRepository.findByNameContainingIgnoreCase((keyword));
    }
}
