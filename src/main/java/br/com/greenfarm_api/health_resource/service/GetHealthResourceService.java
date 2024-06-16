package br.com.greenfarm_api.health_resource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.greenfarm_api.health_resource.dto.HealthResourceDTO;
import br.com.greenfarm_api.health_resource.entity.repository.HealthResourceRepository;

@Service
public class GetHealthResourceService {

  @Autowired
  private HealthResourceRepository repository;
  
  public List<HealthResourceDTO> findAll() {
    return repository.findAll().stream().map(HealthResourceDTO::new).toList();
  }
}
