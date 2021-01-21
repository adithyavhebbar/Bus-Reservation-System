package hebbar.brs.controller;

import hebbar.brs.DTO.UserDto;
import hebbar.brs.entities.User;
import hebbar.brs.services.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/users")
public class UserAccessController {

    private UserCrudService userCrudService;

    @Autowired
    public UserAccessController(UserCrudService userCrudService) {
        this.userCrudService = userCrudService;
    }

    @GetMapping("/get")
    public ResponseEntity<UserDto> getUserById(@RequestParam(name = "email") final String email,
                                               @RequestHeader("Authorization") final String bearerToken) {
        User user = this.userCrudService.findByUserEmail(email, bearerToken);
        UserDto userDto = new UserDto()
                .setStatus(HttpStatus.OK.toString())
                .setDescription("ACCEPT")
                .setUserDetails(new ArrayList<User>(Arrays.asList(user)));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
