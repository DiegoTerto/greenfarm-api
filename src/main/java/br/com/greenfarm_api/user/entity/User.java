package br.com.greenfarm_api.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "users")
@Entity(name = "User")
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password =  password;
    }
}
