package ru.mephi.gpus_statistics.entity.products.dto.product;

import lombok.Data;

@Data
public class ProductRqDto {
    private String productId;
    private double oldCost;
    private double newCost;
}
