package hebbar.brs.controller;

import hebbar.brs.models.UserDetailsImpl;
import hebbar.brs.services.exception.IllegalValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hebbar.brs.models.util.JwtAuthenticationRequest;
import hebbar.brs.models.util.JwtAuthenticationResponse;
import hebbar.brs.services.FetchUserDetailsService;
import hebbar.brs.services.JwtUtil;

@RestController
@RequestMapping("/api/authentication")
public class JwtAuthenticaterController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private FetchUserDetailsService fetchUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtAuthenticationResponse> authentciate(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtAuthenticationRequest.getEmail(), jwtAuthenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect UserName or Password");
        }
        final UserDetailsImpl userDetails = fetchUserDetailService.loadUserByUsername(jwtAuthenticationRequest.getEmail());
        String jwtToken = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken));
    }

    @GetMapping("/get")
    public String getUser() {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        System.out.println(httpStatus);
        throw new IllegalValueException("Cannot get values");
    }
}
