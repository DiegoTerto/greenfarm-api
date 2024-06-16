package br.com.greenfarm_api.health_resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.greenfarm_api.health_resource.dto.HealthResourceDTO;
import br.com.greenfarm_api.health_resource.dto.PersistHealthResourceDTO;
import br.com.greenfarm_api.health_resource.service.CreateHealthResourceService;
import br.com.greenfarm_api.health_resource.service.GetHealthResourceService;

@RestController
@RequestMapping("health-resource")
public class HealthResourceController {
  
  @Autowired
  private CreateHealthResourceService createHealthResourceService;
  @Autowired
  private GetHealthResourceService getHealthResourceService;

  @PostMapping
  public ResponseEntity create(@RequestBody PersistHealthResourceDTO dto) {
    createHealthResourceService.execute(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping
  public ResponseEntity<List<HealthResourceDTO>> findAll() {
    return ResponseEntity.ok(getHealthResourceService.findAll());
  }
}
