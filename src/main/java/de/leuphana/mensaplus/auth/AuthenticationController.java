package de.leuphana.mensaplus.auth;

import de.leuphana.mensaplus.auth.user.User;
import de.leuphana.mensaplus.auth.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    /* Generiert ein JWT Bearer Token */
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return authenticationService.createAuthenticationToken(authenticationRequest);
    }
}
