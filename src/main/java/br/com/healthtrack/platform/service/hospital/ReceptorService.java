package br.com.healthtrack.platform.service.hospital;

import br.com.healthtrack.platform.domain.Hospital;
import br.com.healthtrack.platform.domain.Receptor;
import br.com.healthtrack.platform.repository.ReceptorRepository;
import br.com.healthtrack.platform.service.HospitalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceptorService extends HospitalUserService {

    @Autowired
    private ReceptorRepository receptorRepository;

    public ReceptorService() {
    }

    @Transactional
    public Receptor createReceptor(Receptor receptor) {
        receptor.setHospital(new Hospital(getHospitalId()));
        return receptorRepository.save(receptor);
    }

    @Transactional
    public Optional<Receptor> updateReceptor(Integer codigo, Receptor updatedReceptor) {
        return findReceptor(codigo).map(r -> {
            r.setDataNascimento(updatedReceptor.getDataNascimento());
            r.setRg(updatedReceptor.getRg());
            r.setCpf(updatedReceptor.getCpf());
            r.setTelefone(updatedReceptor.getTelefone());
            return Optional.of(receptorRepository.saveAndFlush(r));
        }).orElse(Optional.empty());
    }

    public List<Receptor> findReceptores() {
        return receptorRepository.findAllByHospital_Codigo(getHospitalId())
                .stream()
                .filter(f -> !f.isArquivado())
                .collect(Collectors.toList());
    }

    public Optional<Receptor> findReceptor(Integer codigoReceptor) {
        return receptorRepository.queryFindReceptor(getHospitalId(), codigoReceptor);
    }

    @Transactional
    public boolean deleteReceptor(Integer codigo) {
        Optional<Receptor> receptor = findReceptor(codigo);

        if(receptor.isPresent()) {
            Receptor receptorArquivado = receptor.get();
            receptorArquivado.setArquivado(true);
            updateReceptor(codigo, receptorArquivado);

            return true;
        }

        return false;
    }
}
