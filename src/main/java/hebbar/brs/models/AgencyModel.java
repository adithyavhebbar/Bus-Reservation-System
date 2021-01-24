package hebbar.brs.models;

public class AgencyModel {
    private String code;
    private String name;
    private String details;
    private Long ownerId;

    public AgencyModel(String code, String name, String details, Long ownerId) {
        this.code = code;
        this.name = name;
        this.details = details;
        this.ownerId = ownerId;
    }

    public String getCode() {
        return code;
    }

    public AgencyModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public AgencyModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public AgencyModel setDetails(String details) {
        this.details = details;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public AgencyModel setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }
}
