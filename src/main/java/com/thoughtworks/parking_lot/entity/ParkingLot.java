package com.thoughtworks.parking_lot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingLot {
    @Id
    @Column(unique = true)
    private String name;

    @NotNull
    private int capacity;

    @NotNull
    private String location;

    public ParkingLot() {
    }

    public ParkingLot(String name, @NotNull int capacity, @NotNull String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
