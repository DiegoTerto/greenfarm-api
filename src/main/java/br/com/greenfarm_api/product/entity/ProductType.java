package br.com.greenfarm_api.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {
    SOY("Soja"),
    COFFEE("Café"),
    WHEAT("Trigo"),
    COTTON("Algodão");

    private final String description;
}
