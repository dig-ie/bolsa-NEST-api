package com.simulador.simulador_bolsa_backend.domain.user.repository;

import com.simulador.simulador_bolsa_backend.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}