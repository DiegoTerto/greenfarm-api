package br.com.greenfarm_api.user.repository;

import br.com.greenfarm_api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmailAndPassword(String email, String password);
}
