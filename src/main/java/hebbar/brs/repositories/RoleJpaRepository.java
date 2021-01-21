package hebbar.brs.repositories;

import hebbar.brs.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleJpaRepository extends JpaRepository<Role, Long> {
}
