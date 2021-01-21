package hebbar.brs.controller;

import hebbar.brs.models.UserModel;
import hebbar.brs.models.util.JwtAuthenticationResponse;
import hebbar.brs.services.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/new")
public class UserAddController {

    @Autowired
    private UserCrudService userCrudService;

    @Autowired
    private JwtAuthenticaterController jwtAuthenticaterController;

    @PostMapping("/user")
    public ResponseEntity<JwtAuthenticationResponse> addNewUser(@RequestBody UserModel userModel,
                                                                @RequestHeader("Authorization") final String bearerToken) {
        JwtAuthenticationResponse response = userCrudService.addNewUser(userModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
