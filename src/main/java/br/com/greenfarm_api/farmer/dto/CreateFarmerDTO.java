package br.com.greenfarm_api.farmer.dto;

import br.com.greenfarm_api.address.dto.PersistAddressDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateFarmerDTO {
    @Pattern(regexp = "[A-Z][A-Za-z1-9]", message = "Nome inválido")
    private String name;
    @Email(message = "Email inválido")
    private String email;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$", message = "Senha inválida")
    private String password;
    private PersistAddressDTO address;
}
