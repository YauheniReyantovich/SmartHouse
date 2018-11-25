package com.sample.controller.json;

public class NewSensor {
    private Integer id;
    private String name;
    private String comment;

    public NewSensor(){}

    public NewSensor(Integer id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "NewSensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
