package br.com.greenfarm_api.health_resource.entity.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.greenfarm_api.health_resource.entity.HealthResource;

@Repository
public interface HealthResourceRepository extends JpaRepository<HealthResource, UUID> {
  
}
