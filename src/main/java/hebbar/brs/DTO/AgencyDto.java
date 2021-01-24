package hebbar.brs.DTO;

import hebbar.brs.entities.Agency;

import java.util.List;

public class AgencyDto {
    private String status;
    private String description;
    private List<Agency> agencies;

    public AgencyDto() {
    }

    public AgencyDto(String status, String description, List<Agency> agencies) {
        this.status = status;
        this.description = description;
        this.agencies = agencies;
    }

    public String getStatus() {
        return status;
    }

    public AgencyDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AgencyDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public AgencyDto setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
        return this;
    }
}
