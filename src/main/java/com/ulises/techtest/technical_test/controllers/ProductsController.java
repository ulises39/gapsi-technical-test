package com.ulises.techtest.technical_test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulises.techtest.technical_test.common.exceptions.ResourceNotFoundException;
import com.ulises.techtest.technical_test.dtos.ProductDto;
import com.ulises.techtest.technical_test.entities.Product;
import com.ulises.techtest.technical_test.repositories.ProductsRepository;

import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping
    public Iterable<Product> getProducts() {
        return this.productsRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody ProductDto productDto) {
        Product product = new Product(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getModel());

        return this.productsRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") UUID productId) {
        return this.findProductById(productId);
    }

    @PutMapping("/{id}")    
    public Product updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable("id") UUID productId) {
        Product product = this.findProductById(productId);

        product.setDescription(productDto.getDescription());
        product.setModel(productDto.getModel());

        return this.productsRepository.save(product);
    }


    private Product findProductById(UUID productId) {
        return this.productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId));
    }

}
