package hebbar.brs.repositories;

import hebbar.brs.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusJpaRepository extends JpaRepository<Bus, Long> {
}
