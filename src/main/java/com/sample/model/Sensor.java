package com.sample.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="SENSOR")
public class Sensor implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="NAME", nullable=false)
    private String name;

    @NotEmpty
    @Column(name="STATE_TYPE", nullable=false)
    private String stateType;

    @NotEmpty
    @Column(name="STATE", nullable=false)
    private String state;

    @Column(name="COMMENT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;

    public Sensor(){}

    public Long getSensorId() {
        return id;
    }

    public void setSensorId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id) &&
                Objects.equals(name, sensor.name) &&
                Objects.equals(stateType, sensor.stateType) &&
                Objects.equals(state, sensor.state) &&
                Objects.equals(comment, sensor.comment) &&
                Objects.equals(userId, sensor.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stateType, state, comment, userId);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorId=" + id +
                ", name='" + name + '\'' +
                ", stateType='" + stateType + '\'' +
                ", state='" + state + '\'' +
                ", comment='" + comment + '\'' +
                ", userId=" + userId +
                '}';
    }
}
