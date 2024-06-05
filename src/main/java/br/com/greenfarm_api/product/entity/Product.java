package br.com.greenfarm_api.product.entity;

import br.com.greenfarm_api.farmer.entity.Farmer;
import br.com.greenfarm_api.product.dto.PersistProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "product")
@Entity(name = "Product")
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_product")
    private ProductType type;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    public Product(PersistProductDTO dto, Farmer farmer) {
        this.name = dto.getProductName();
        this.description = dto.getDescription();
        this.farmer = farmer;
        this.type = dto.getType();
        this.price = dto.getPrice();
    }
}
