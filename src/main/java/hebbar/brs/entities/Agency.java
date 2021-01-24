package hebbar.brs.entities;

import hebbar.brs.models.AgencyModel;

import javax.persistence.*;

@Entity
@Table(name = "agency")
public class Agency {

    @Id
    @SequenceGenerator(name = "agency_pk_sequence", sequenceName = "agency_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_pk_sequence")
    @Column(name = "\"id\"")
    private Long id;

    @Column(name = "\"code\"", unique = true, nullable = false)
    private String code;

    @Column(name = "\"name\"")
    private String name;

    @Column(name = "\"details\"")
    private String details;

    @Column(name = "\"owner\"")
    private Long ownerId;

    public Agency() {
    }

    public Agency(AgencyModel agencyModel) {
        this.code = agencyModel.getCode();
        this.details = agencyModel.getDetails();
        this.name = agencyModel.getName();
        this.ownerId = agencyModel.getOwnerId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
