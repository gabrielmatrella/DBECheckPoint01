package br.com.healthtrack.platform.repository;

import br.com.healthtrack.platform.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
