package br.com.greenfarm_api.product.service;

import br.com.greenfarm_api.farmer.service.GetFarmerService;
import br.com.greenfarm_api.product.dto.PersistProductDTO;
import br.com.greenfarm_api.product.entity.Product;
import br.com.greenfarm_api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class CreateProductService {

    @Autowired
    private GetFarmerService getFarmerService;

    @Autowired
    private ProductRepository productRepository;

    private HashMap<UUID, Set<UUID>> farmerProductGraph = new HashMap<>();

    public void execute(PersistProductDTO dto) {
        var farmer = getFarmerService.findById(dto.getFarmerId());
        var product = new Product(dto, farmer);
        productRepository.save(product);
        if (!farmerProductGraph.containsKey(farmer.getId())) {
            farmerProductGraph.putIfAbsent(farmer.getId(), new HashSet<>());
        }
        farmerProductGraph.get(farmer.getId()).add(product.getId());
    }
}
