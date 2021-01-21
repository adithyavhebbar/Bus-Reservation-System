package hebbar.brs.services;

import hebbar.brs.entities.User;
import hebbar.brs.models.UserCrudInterface;
import hebbar.brs.models.UserDetailsImpl;
import hebbar.brs.models.UserModel;
import hebbar.brs.models.util.JwtAuthenticationResponse;
import hebbar.brs.repositories.UserJpaRepository;
import hebbar.brs.services.exception.IllegalValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hebbar.brs.services.UserTokenAuthenticator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserCrudService implements UserCrudInterface {

    private UserTokenAuthenticator userTokenAuthenticator;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AddUserValidator addUserValidator;

    @Autowired
    public UserCrudService(UserTokenAuthenticator userTokenAuthenticator) {
        this.userTokenAuthenticator = userTokenAuthenticator;
    }

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User findByUserEmail(String email, String bearerToken) {
        if (userTokenAuthenticator.isValidUser(email, bearerToken)) {
            User user = this.userJpaRepository
                    .findByEmail(email)
                    .map(User::new)
                    .orElseThrow(() -> new IllegalValueException("No such User Exists with that email"));
            return user;
        } else {
            throw new IllegalValueException("No such User Exists with that email");
        }
    }

    @Override
    public JwtAuthenticationResponse addNewUser(UserModel userModel) {
        boolean validEmail = addUserValidator.isValidEmail(userModel.getEmail());
        boolean validPhone = addUserValidator.isValidPhoneNumber(userModel.getMobile());
        boolean validFirstName = !(addUserValidator.isValidNames(userModel.getFirstName()));
        boolean validLastName = !(addUserValidator.isValidNames(userModel.getLastName()));
        if (validEmail && validPhone && validFirstName && validLastName) {
            User user = new User(userModel);
            User savedUser = userJpaRepository.save(user);
            UserDetailsImpl userDetails = new UserDetailsImpl(savedUser);
            String token = jwtUtil.generateToken(userDetails);
            JwtAuthenticationResponse response = new JwtAuthenticationResponse(token);
            return response;
        } else {
            boolean[] fieldCheckArray = new boolean[]{validEmail, validFirstName, validLastName, validPhone};
            throw new IllegalValueException("One or More Input Fields are wrong");
        }
    }
}


