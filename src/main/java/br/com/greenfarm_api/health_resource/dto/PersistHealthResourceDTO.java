package br.com.greenfarm_api.health_resource.dto;

import java.util.UUID;

import br.com.greenfarm_api.health_resource.entity.HeathResourceType;
import lombok.Getter;
import lombok.NoArgsConstructor;

public record PersistHealthResourceDTO(
  String name,
  String description,
  HeathResourceType type,
  UUID farmerId
) {
  
}
