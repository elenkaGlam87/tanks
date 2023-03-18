package com.example.containers.service;

import com.example.containers.dao.ContainerDao;
import com.example.containers.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ContainerServiceImpl implements ContainerService {

    ContainerDao dao;

    @Autowired
    public ContainerServiceImpl(ContainerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Container> getAllContainers() {
        return dao.getAll();
    }

    @Override
    public List<Container> createContainer(int amount) {
        List<Container> containers = dao.getAll();
        for (int i = 0; i < amount; i++) {
            containers.add(new Container());
        }
        return containers;
    }

    @Override
    public List<Container> addWater(Long id, int waterAmount) {
        List<Container> containers = dao.getAll();
        final Container container = containers.get(Math.toIntExact(id - 1));
        if ((waterAmount + container.getWaterAmount()) < 0) {
            container.setWaterAmount(0);
        } else {
            container.setWaterAmount(waterAmount + container.getWaterAmount());
        }
        Set<Long> connection = container.getPipe();
        setWaterToConnectContainers(containers, connection);
        return containers;

    }

    @Override
    public List<Container> connectTo(Long id, Long otherId) {
        List<Container> containers = dao.getAll();
        Set<Long> connection = new HashSet<>();
        connection.addAll(containers.get(Math.toIntExact(id - 1)).getPipe());
        connection.addAll(containers.get(Math.toIntExact(otherId - 1)).getPipe());
        for (Long pid : connection) {
            containers.get(Math.toIntExact(pid - 1)).setPipe(connection);
        }
        setWaterToConnectContainers(containers, connection);
        return containers;
    }

    @Override
    public void setWaterToConnectContainers(List<Container> containers, Set<Long> pipeSet) {
        double waterAmount = 0;
        for (Long pid : pipeSet) {
            waterAmount = waterAmount + containers.get(Math.toIntExact(pid - 1)).getWaterAmount();
        }
        double totalWater = waterAmount / pipeSet.size();
        for (Long pid : pipeSet) {
            containers.get(Math.toIntExact(pid - 1)).setWaterAmount(totalWater);
        }
    }

}
