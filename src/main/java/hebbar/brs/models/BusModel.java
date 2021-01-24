package hebbar.brs.models;

public class BusModel {
    private String code;
    private Integer capacity;
    private String make;
    private Long agency;

    public BusModel(String code, Integer capacity, String make, Long agency) {
        this.code = code;
        this.capacity = capacity;
        this.make = make;
        this.agency = agency;
    }

    public BusModel() {
    }

    public String getCode() {
        return code;
    }

    public BusModel setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public BusModel setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getMake() {
        return make;
    }

    public BusModel setMake(String make) {
        this.make = make;
        return this;
    }

    public Long getAgency() {
        return agency;
    }

    public BusModel setAgency(Long agency) {
        this.agency = agency;
        return this;
    }
}
