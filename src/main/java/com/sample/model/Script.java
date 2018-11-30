package com.sample.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="SCRIPT")
public class Script implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SENSOR_ID")
    private Sensor sensorId;

    @ManyToOne
    @JoinColumn(name = "CONTROL_ID")
    private Sensor controlID;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;

    @NotEmpty
    @Column(name="CONDITION", nullable=false)
    private String condition;

    @Column(name="COMPARED_VALUE")
    private String comparedValue;

    @NotEmpty
    @Column(name="ACTION", nullable=false)
    private String action;

    @NotEmpty
    @Column(name="IS_WORKING", nullable = false)
    private  Boolean isWorking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensorId() {
        return sensorId;
    }

    public void setSensorId(Sensor sensorId) {
        this.sensorId = sensorId;
    }

    public Sensor getControlID() {
        return controlID;
    }

    public void setControlID(Sensor controlID) {
        this.controlID = controlID;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getComparedValue() {
        return comparedValue;
    }

    public void setComparedValue(String comparedValue) {
        this.comparedValue = comparedValue;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Script script = (Script) o;
        return Objects.equals(id, script.id) &&
                Objects.equals(sensorId, script.sensorId) &&
                Objects.equals(controlID, script.controlID) &&
                Objects.equals(userId, script.userId) &&
                Objects.equals(condition, script.condition) &&
                Objects.equals(comparedValue, script.comparedValue) &&
                Objects.equals(action, script.action) &&
                Objects.equals(isWorking, script.isWorking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sensorId, controlID, userId, condition, comparedValue, action, isWorking);
    }

    @Override
    public String toString() {
        return "Script{" +
                "id=" + id +
                ", sensorId=" + sensorId +
                ", controlID=" + controlID +
                ", userId=" + userId +
                ", condition='" + condition + '\'' +
                ", comparedValue='" + comparedValue + '\'' +
                ", action='" + action + '\'' +
                ", isWorking=" + isWorking +
                '}';
    }
}
