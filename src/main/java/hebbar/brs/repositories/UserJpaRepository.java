package hebbar.brs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hebbar.brs.entities.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);

}
