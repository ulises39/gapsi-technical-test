package com.ulises.techtest.technical_test.entities;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20, nullable = false, updatable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2, updatable = false)
    private BigDecimal price;

    @Column(length = 10, nullable = false)
    private String model;

    // Constructors
    public Product() {
    }

    public Product(String name, String description, BigDecimal price, String model) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.model = model;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
