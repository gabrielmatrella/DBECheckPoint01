package br.com.healthtrack.platform;

import br.com.healthtrack.platform.domain.Credencial;
import br.com.healthtrack.platform.domain.Hospital;
import br.com.healthtrack.platform.domain.TipoUsuario;
import br.com.healthtrack.platform.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PlatformApplication {

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return (args -> {
            Credencial credencial = new Credencial();
            credencial.setEmail("hospital-master@example.com");
            credencial.setSenha(bCryptPasswordEncoder.encode("1234"));
            credencial.setTipoUsuario(TipoUsuario.ADMIN);

            Hospital hospital = new Hospital();
            hospital.addCredencial(credencial);
            hospital.setLatitude("-431");
            hospital.setLongitude("423");
            hospital.setNome("Hospital teste");

            hospitalRepository.save(hospital);
        });
    }
}
