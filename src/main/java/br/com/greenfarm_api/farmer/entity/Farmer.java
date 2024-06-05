package br.com.greenfarm_api.farmer.entity;

import br.com.greenfarm_api.address.entity.Address;
import br.com.greenfarm_api.farmer.dto.CreateFarmerDTO;
import br.com.greenfarm_api.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "farmer")
@Entity(name = "Farmer")
@NoArgsConstructor
@Getter
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Farmer(CreateFarmerDTO dto) {
        this.user = new User(dto.getEmail(), dto.getPassword());
        this.name = dto.getName();
        this.address = new Address(dto.getAddress(), this);
    }
}
