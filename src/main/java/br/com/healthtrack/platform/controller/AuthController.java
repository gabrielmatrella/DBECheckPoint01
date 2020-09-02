package br.com.healthtrack.platform.controller;

import br.com.healthtrack.platform.security.HospitalUserDetails;
import br.com.healthtrack.platform.security.jwt.JwtTokenService;
import br.com.healthtrack.platform.security.model.AuthenticationRequestModel;
import br.com.healthtrack.platform.security.model.AuthenticationResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestModel authenticationRequestModel) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(authenticationRequestModel.getEmail(), authenticationRequestModel.getPassword());

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        HospitalUserDetails hospitalUserDetails = (HospitalUserDetails) authenticate.getPrincipal();
        String token = jwtTokenService.createToken(hospitalUserDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponseModel(token));
    }


}
