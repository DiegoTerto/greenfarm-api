package br.com.greenfarm_api.product.dto;

import br.com.greenfarm_api.product.entity.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class PersistProductDTO {
    private UUID farmerId;
    private String productName;
    private String description;
    private ProductType type;
    private BigDecimal price;
}
