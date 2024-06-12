package br.com.greenfarm_api.product.service;

import br.com.greenfarm_api.product.dto.ProductDTO;
import br.com.greenfarm_api.product.entity.Product;
import br.com.greenfarm_api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GetProductService {

    @Autowired
    private ProductRepository productRepository;

    private ConcurrentHashMap<UUID, Product> productCache = new ConcurrentHashMap<>();

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(ProductDTO::new).toList();
    }

    public ProductDTO getByName(String name) {
        TreeMap<String, Product> productTree = new TreeMap<>();

        var allProducts = productRepository.findAll();
        allProducts.forEach((product -> productTree.put(product.getName(), product)));

        var productFiltered = productTree.get(name);
        return new ProductDTO(productFiltered);
    }

    public ProductDTO getById(UUID id) {
        if (productCache.containsKey(id)) {
            return new ProductDTO(productCache.get(id));
        }

        var product = productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        productCache.put(product.getId(), product);
        return new ProductDTO(product);
    }
}
