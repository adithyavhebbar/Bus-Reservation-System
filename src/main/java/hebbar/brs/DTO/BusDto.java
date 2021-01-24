package hebbar.brs.DTO;

import hebbar.brs.entities.Bus;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BusDto {
    private HttpStatus httpStatus;
    private String description;
    private List<Bus> buses;

    public BusDto() {
    }

    public BusDto(HttpStatus httpStatus, String description, List<Bus> buses) {
        this.httpStatus = httpStatus;
        this.description = description;
        this.buses = buses;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public BusDto setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BusDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public BusDto setBuses(List<Bus> buses) {
        this.buses = buses;
        return this;
    }
}
