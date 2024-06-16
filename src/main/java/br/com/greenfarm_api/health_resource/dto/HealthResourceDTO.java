package br.com.greenfarm_api.health_resource.dto;

import br.com.greenfarm_api.farmer.dto.FarmerDTO;
import br.com.greenfarm_api.health_resource.entity.HealthResource;
import br.com.greenfarm_api.health_resource.entity.HeathResourceType;

public record HealthResourceDTO(
  String name,
  String description,
  HeathResourceType type,
  FarmerDTO farmer
) {
  public HealthResourceDTO(HealthResource healthResource) {
    this(healthResource.getName(), healthResource.getDescription(), healthResource.getType(), new FarmerDTO(healthResource.getFarmer()));
  }
}
