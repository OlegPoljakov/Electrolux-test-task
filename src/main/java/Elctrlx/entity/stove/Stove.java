package Elctrlx.entity.stove;

import javax.persistence.*;

@Entity
@Table(name = "stove")
public class Stove {

    @Id
    @Column(name = "STOVE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "STATE")
    private String state = "Off";

    @Column(name = "STOVE_TEMPERATURE")
    private Integer stoveTemperature = 0;

    public Stove() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStoveTemperature() {
        return stoveTemperature;
    }

    public void setStoveTemperature(Integer stoveTemperature) {
        this.stoveTemperature = stoveTemperature;
    }

    @Override
    public String toString() {
        return "Stove{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", state='" + state + '\'' +
                ", stoveTemperature=" + stoveTemperature +
                '}';
    }
}

