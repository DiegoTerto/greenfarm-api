package br.com.greenfarm_api.health_resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.greenfarm_api.farmer.service.GetFarmerService;
import br.com.greenfarm_api.health_resource.dto.PersistHealthResourceDTO;
import br.com.greenfarm_api.health_resource.entity.HealthResource;
import br.com.greenfarm_api.health_resource.entity.repository.HealthResourceRepository;

@Service
public class CreateHealthResourceService {

  @Autowired
  private GetFarmerService getFarmerService;

  @Autowired
  private HealthResourceRepository repository;

  public void execute(PersistHealthResourceDTO dto) {
    var farmer = getFarmerService.findById(dto.farmerId());

    var healthResource = new HealthResource(dto, farmer);

    repository.save(healthResource);
  }
  
}
