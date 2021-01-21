package hebbar.brs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserTokenAuthenticator {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean isValidUser(String email, String bearerToken) {
        String token = bearerToken.substring(7);
        String emailFromToken = this.jwtUtil.extractUsername(token);
        System.out.println(emailFromToken);
        if (emailFromToken.compareTo(email) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
