package ru.mephi.gpus_statistics.entity.products.dto.product;

import lombok.Data;
import ru.mephi.gpus_statistics.entity.clients.Client;

import java.util.List;

@Data
public class ProductRsDto {
    private List<Client> clients;
    private String productId;
    private double oldCost;
    private double newCost;
}
