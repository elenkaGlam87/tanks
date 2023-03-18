package com.example.containers.service;

import com.example.containers.model.Container;

import java.util.List;
import java.util.Set;

public interface ContainerService {

    List<Container> getAllContainers();

    List<Container> createContainer(int amount);

    List<Container> addWater(Long id, int waterAmount);

    List<Container> connectTo(Long id, Long otherId);

    void setWaterToConnectContainers(List<Container> containers, Set<Long> pipeSet);

}
