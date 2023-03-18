package com.example.containers.dao;

import com.example.containers.model.Container;
import com.example.containers.service.ContainerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContainerDao {

    private static final List<Container> containers = new ArrayList<>();


    public List<Container> getAll() {
        return containers;
    }
}
