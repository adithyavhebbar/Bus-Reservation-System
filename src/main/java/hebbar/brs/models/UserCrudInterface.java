package hebbar.brs.models;

import hebbar.brs.entities.User;
import hebbar.brs.models.util.JwtAuthenticationResponse;

import java.util.List;
import java.util.Optional;

public interface UserCrudInterface {
    User findByUserEmail(String email, String token);

    JwtAuthenticationResponse addNewUser(UserModel userModel);
}
