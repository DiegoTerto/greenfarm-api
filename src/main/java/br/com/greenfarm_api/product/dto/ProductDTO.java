package br.com.greenfarm_api.product.dto;

import br.com.greenfarm_api.farmer.dto.FarmerDTO;
import br.com.greenfarm_api.product.entity.Product;
import br.com.greenfarm_api.product.entity.ProductType;

import java.math.BigDecimal;

public record ProductDTO(
        String name,
        String description,
        ProductType type,
        BigDecimal price,
        FarmerDTO farmer
) {

    public ProductDTO(Product product) {
        this(product.getName(), product.getDescription(),product.getType(), product.getPrice(), new FarmerDTO(product.getFarmer()));
    }
}
