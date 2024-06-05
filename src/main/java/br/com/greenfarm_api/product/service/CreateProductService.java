package br.com.greenfarm_api.product.service;

import br.com.greenfarm_api.farmer.service.GetFarmerService;
import br.com.greenfarm_api.product.dto.PersistProductDTO;
import br.com.greenfarm_api.product.entity.Product;
import br.com.greenfarm_api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

    @Autowired
    private GetFarmerService getFarmerService;

    @Autowired
    private ProductRepository productRepository;

    public void execute(PersistProductDTO dto) {
        var farmer = getFarmerService.findById(dto.getFarmerId());
        var product = new Product(dto, farmer);
        productRepository.save(product);
    }
}
