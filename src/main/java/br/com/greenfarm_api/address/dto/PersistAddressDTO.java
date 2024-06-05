package br.com.greenfarm_api.address.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PersistAddressDTO {
    private String city;
    private String state;
    private String postalCode;
    private String publicPlace;
    private String complement;
}
