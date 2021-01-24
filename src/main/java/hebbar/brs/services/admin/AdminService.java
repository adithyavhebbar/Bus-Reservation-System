package hebbar.brs.services.admin;

import hebbar.brs.entities.Agency;
import hebbar.brs.entities.Bus;
import hebbar.brs.models.AgencyModel;
import hebbar.brs.models.BusModel;
import hebbar.brs.repositories.AgencyJpaRepository;
import hebbar.brs.repositories.BusJpaRepository;
import hebbar.brs.services.exception.IllegalValueException;
import hebbar.brs.services.exception.postgresql.DataIntegrityVoilationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AgencyJpaRepository agencyJpaRepository;

    @Autowired
    private BusJpaRepository busJpaRepository;

    public Agency addAgency(AgencyModel agencyModel) {
        try {
            Agency agency = agencyJpaRepository.save(new Agency(agencyModel));
            return agency;
        } catch (IllegalArgumentException e) {
            throw new IllegalValueException("Value Cannot be null or Empty");
        }
    }

    public List<Agency> getAllAgency() {
        return agencyJpaRepository.findAll(Sort.by("name", "code").ascending());
    }

    public Bus addNewBusToAgency(BusModel busModel) {
        try {
            Bus bus = this.busJpaRepository.save(new Bus()
                    .setCode(busModel.getCode())
                    .setCapacity(busModel.getCapacity())
                    .setMake(busModel.getMake())
                    .setAgency(busModel.getAgency()));

            return bus;
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DataIntegrityVoilationException("Code already exists");
        }
    }

    public List<Bus> getAllBusInAgency() {
        List<Bus> buses = this.busJpaRepository.findAll(Sort.by("code", "make").ascending());
        return buses;
    }
}
