package br.com.healthtrack.platform.repository;

import br.com.healthtrack.platform.domain.Receptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReceptorRepository extends JpaRepository<Receptor, Integer> {

    List<Receptor> findAllByHospital_Codigo(Integer codigoHospital);

    @Query("select r from Receptor r where r.hospital.codigo=?1 and r.codigo=?2 and r.arquivado = false")
    Optional<Receptor> queryFindReceptor(Integer codigoHospital, Integer codigoPaciente);

}
