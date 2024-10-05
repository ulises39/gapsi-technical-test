package com.ulises.techtest.technical_test.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ulises.techtest.technical_test.entities.Product;

public interface ProductsRepository extends JpaRepository<Product, UUID> {
}
