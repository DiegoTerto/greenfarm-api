package br.com.greenfarm_api.farmer.repository;

import br.com.greenfarm_api.farmer.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, UUID> {
    Optional<Farmer> findByUserEmailAndUserPassword(String email, String password);
}
