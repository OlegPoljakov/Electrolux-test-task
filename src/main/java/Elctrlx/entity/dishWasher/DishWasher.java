package Elctrlx.entity.dishWasher;

import javax.persistence.*;

@Entity
@Table(name = "dishwasher")
public class DishWasher {

    @Id
    @Column(name = "DISHWASHER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "STATE")
    private String state = "Off";

    @Column(name = "WATER_TEMPERATURE")
    private Integer waterTemperature = 0;

    public DishWasher() {
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

    public Integer getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Integer waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    @Override
    public String toString() {
        return "DishWasher{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", state=" + state +
                ", waterTemperature=" + waterTemperature +
                '}';
    }
}
