package com.example.flexiblebackend.models;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="modelName")
    private String modelName;

    protected Car() {}

    public Car(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return String.format(
                "Car[id=%d, modelName='%s']",
                id, modelName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}