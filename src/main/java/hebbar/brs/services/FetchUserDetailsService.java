package hebbar.brs.services;

import java.util.Optional;

import hebbar.brs.services.exception.IllegalValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hebbar.brs.entities.User;
import hebbar.brs.models.UserDetailsImpl;
import hebbar.brs.repositories.UserJpaRepository;

@Service
public class FetchUserDetailsService implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;


    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userJpaRepository.findByEmail(email)
                .map(User::new)
                .orElseThrow(() -> new IllegalValueException("No such Value Exists"));
        return new UserDetailsImpl(user);
    }

}
