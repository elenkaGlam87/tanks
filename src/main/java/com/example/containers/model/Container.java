package com.example.containers.model;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class Container {

    public static final AtomicLong counter = new AtomicLong();

    private Long id;

    private double waterAmount;

    Set<Long> pipe = new HashSet<>();

    public Container(Long id, Double waterAmount) {
        this.id = id;
        this.waterAmount = waterAmount;
    }

    public Container() {
        this.id = counter.incrementAndGet();
        this.pipe.add(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    public Set<Long> getPipe() {
        return pipe;
    }

    public void setPipe(Set<Long> pipe) {
        this.pipe = pipe;
    }
}
