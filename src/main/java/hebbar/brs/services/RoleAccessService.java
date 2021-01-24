package hebbar.brs.services;

import hebbar.brs.repositories.RoleJpaRepository;
import hebbar.brs.services.exception.IllegalValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleAccessService {

    @Autowired
    private RoleJpaRepository roleJpaRepository;

    public boolean isAdmin(Long id) {
        String roles = roleJpaRepository.findById(id)
                .map(role -> {
                    return role.getRole();
                })
                .orElseThrow(() -> new IllegalValueException("Not Allowed"));
        if (roles.compareTo("admin") == 0) {
            return true;
        } else {
            return false;
        }
    }
}
