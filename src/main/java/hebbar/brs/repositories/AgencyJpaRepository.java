package hebbar.brs.repositories;

import hebbar.brs.entities.Agency;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyJpaRepository extends JpaRepository<Agency, Long> {
}
