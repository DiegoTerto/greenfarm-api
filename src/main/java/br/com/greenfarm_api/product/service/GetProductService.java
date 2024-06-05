package br.com.greenfarm_api.product.service;

import br.com.greenfarm_api.product.dto.ProductDTO;
import br.com.greenfarm_api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(ProductDTO::new).toList();
    }
}
