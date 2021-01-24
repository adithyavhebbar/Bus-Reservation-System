package hebbar.brs.entities;

import hebbar.brs.models.BusModel;

import javax.persistence.*;

@Entity
@Table(name = "\"bus\"")
public class Bus {
    @Id
    @SequenceGenerator(name = "bus_pk_sequence", sequenceName = "bus_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_pk_sequence")
    @Column(name = "\"id\"", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "\"code\"", unique = true)
    private String code;

    @Column(name = "\"capacity\"")
    private Integer capacity;

    @Column(name = "\"make\"")
    private String make;

    @Column(name = "\"agency\"")
    private Long agency;

    public Bus() {
    }

    public Bus(Long id, String code, Integer capacity, String make, Long agency) {
        this.id = id;
        this.code = code;
        this.capacity = capacity;
        this.make = make;
        this.agency = agency;
    }

    public Bus(BusModel busModel) {
        this.code = busModel.getCode();
        this.capacity = busModel.getCapacity();
        this.agency = busModel.getAgency();
        this.make = busModel.getMake();
    }
    public Long getId() {
        return id;
    }

    public Bus setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Bus setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Bus setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getMake() {
        return make;
    }

    public Bus setMake(String make) {
        this.make = make;
        return this;
    }

    public Long getAgency() {
        return agency;
    }

    public Bus setAgency(Long agency) {
        this.agency = agency;
        return this;
    }
}
