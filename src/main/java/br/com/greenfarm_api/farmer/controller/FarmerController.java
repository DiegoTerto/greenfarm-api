package br.com.greenfarm_api.farmer.controller;

import br.com.greenfarm_api.farmer.dto.CreateFarmerDTO;
import br.com.greenfarm_api.farmer.dto.FarmerDTO;
import br.com.greenfarm_api.farmer.dto.FarmerLoginDTO;
import br.com.greenfarm_api.farmer.service.CreateFarmerService;
import br.com.greenfarm_api.farmer.service.FarmerLoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farmer")
public class FarmerController {

    @Autowired
    private CreateFarmerService createFarmerService;

    @Autowired
    private FarmerLoginService farmerLoginService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateFarmerDTO dto) {
        createFarmerService.execute(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("login")
    public ResponseEntity<FarmerDTO> login(@RequestBody @Valid FarmerLoginDTO dto) {
        return ResponseEntity.ok(farmerLoginService.login(dto));
    }
}
