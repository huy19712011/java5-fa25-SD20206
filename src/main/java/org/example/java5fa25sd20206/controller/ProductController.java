package org.example.java5fa25sd20206.controller;

import org.example.java5fa25sd20206.entity.Product;
import org.example.java5fa25sd20206.service.CategoryService;
import org.example.java5fa25sd20206.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {

        // get data from DB
        List<Product> products = productService.getAllProducts();

        // send to view
        model.addAttribute("products", products);

        return "views/products";
    }
}
