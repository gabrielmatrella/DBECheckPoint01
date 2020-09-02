package br.com.healthtrack.platform.security;

import br.com.healthtrack.platform.domain.Credencial;
import br.com.healthtrack.platform.repository.CredencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalUserDetailsService implements UserDetailsService {

    @Autowired
    CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Credencial> byEmail = credencialRepository.findByEmail(email);

        return createUserDetails(byEmail.orElseThrow(() -> {
            throw new UsernameNotFoundException(String.format("Specified email (%s) not found", email));
        }));
    }

    public UserDetails loadUserByCodigo(Integer codigo) throws UsernameNotFoundException {
        Optional<Credencial> byCodigo = credencialRepository.findByCodigo(codigo);

        return createUserDetails(byCodigo.orElseThrow(() -> {
            throw new UsernameNotFoundException(String.format("Specified codigo (%d) not found", codigo));
        }));
    }

    private UserDetails createUserDetails(Credencial credencial) {
        return new HospitalUserDetails(credencial);
    }
}
