package hebbar.brs.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class AddUserValidator {
    public boolean isValidNames(String name) {
        String nameRegExp = "^[a-zA-Z( )]";
        boolean validName = name.matches(nameRegExp);
        if (validName) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberRegExp = "[0-9]{10}";
        boolean validPhoneNumber = phoneNumber.matches(phoneNumberRegExp);
        if (validPhoneNumber) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidEmail(String email) {
        String emailRegExp = "\\S+@\\S+\\.\\S+";
        boolean validEmail = email.matches(emailRegExp);
        if (validEmail) {
            return true;
        } else {
            return false;
        }
    }
}
