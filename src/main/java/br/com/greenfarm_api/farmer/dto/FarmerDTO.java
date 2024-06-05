package br.com.greenfarm_api.farmer.dto;

import br.com.greenfarm_api.farmer.entity.Farmer;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FarmerDTO {
    private String name;
    private String email;

    public FarmerDTO(Farmer farmer) {
        this.name = farmer.getName();
        this.email = farmer.getUser().getEmail();
    }
}
