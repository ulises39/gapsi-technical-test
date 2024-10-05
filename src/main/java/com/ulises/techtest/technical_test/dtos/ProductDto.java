package com.ulises.techtest.technical_test.dtos;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    
    @NotBlank(message = "'name' field is required")
    @Size(message = "'name' cannot be greater than 20 characters", min = 0, max = 20)
    private String name;

    @NotBlank(message = "'description' field is required")
    @Size(message = "'description' cannot be greater than 200 characters", min = 0, max = 200)
    private String description;

    @NotNull(message = "'price' field is required")    
    @Digits(integer = 9, fraction = 2, message = "'price' must be a valid decimal value with a maximum of two decimals")
    private BigDecimal price;

    @NotBlank(message = "'model' field is required")
    @Size(message = "'model' cannot be greater than 10 characters", min = 0, max = 10)
    private String model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
