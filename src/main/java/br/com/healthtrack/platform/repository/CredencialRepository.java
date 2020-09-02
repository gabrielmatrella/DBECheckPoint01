package br.com.healthtrack.platform.repository;

import br.com.healthtrack.platform.domain.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, Integer> {

    Optional<Credencial> findByEmail(String email);

    Optional<Credencial> findByCodigo(Integer codigo);

}
