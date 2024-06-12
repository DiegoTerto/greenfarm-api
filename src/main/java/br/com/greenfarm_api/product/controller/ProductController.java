package br.com.greenfarm_api.product.controller;

import br.com.greenfarm_api.product.dto.PersistProductDTO;
import br.com.greenfarm_api.product.dto.ProductDTO;
import br.com.greenfarm_api.product.service.CreateProductService;
import br.com.greenfarm_api.product.service.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private CreateProductService createProductService;
    @Autowired
    private GetProductService getProductService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersistProductDTO dto) {
        createProductService.execute(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(getProductService.findAll());
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getByName(@RequestParam String name) {
        return ResponseEntity.ok(getProductService.getByName(name));
    }
}
