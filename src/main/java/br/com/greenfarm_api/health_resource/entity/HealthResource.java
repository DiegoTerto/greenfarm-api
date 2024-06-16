package br.com.greenfarm_api.health_resource.entity;

import java.util.UUID;

import br.com.greenfarm_api.farmer.entity.Farmer;
import br.com.greenfarm_api.health_resource.dto.PersistHealthResourceDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "healthresource")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HealthResource {

  @Id
  @GeneratedValue
  private UUID id = UUID.randomUUID();

  private String name;
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(name = "tp_healthresource")
  private HeathResourceType type;

  @ManyToOne
  @JoinColumn(name = "farmer_id")
  private Farmer farmer;
  
  public HealthResource(PersistHealthResourceDTO dto, Farmer farmer) {
    this.name = dto.name();
    this.description = dto.description();
    this.type = dto.type();
    this.farmer = farmer;
  }
}
