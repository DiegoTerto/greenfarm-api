package br.com.greenfarm_api.address.entity;

import br.com.greenfarm_api.address.dto.PersistAddressDTO;
import br.com.greenfarm_api.farmer.entity.Farmer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "address")
@Entity(name = "Address")
@NoArgsConstructor
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "public_place")
    private String publicPlace;

    @OneToOne(mappedBy = "address")
    private Farmer farmer;

    @Column(name = "complement")
    private String complement;

    public Address(PersistAddressDTO dto, Farmer farmer) {
        this.city = dto.getCity();
        this.state = dto.getState();
        this.postalCode = dto.getPostalCode();
        this.publicPlace = dto.getPublicPlace();
        this.farmer = farmer;
        this.complement = dto.getComplement();
    }
}
