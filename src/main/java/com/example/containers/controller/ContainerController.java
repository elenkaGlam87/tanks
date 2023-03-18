package com.example.containers.controller;

import com.example.containers.model.Container;
import com.example.containers.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/containers")
public class ContainerController {

    ContainerService service;

    @Autowired
    public ContainerController(ContainerService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllContainers() {
        try {
            final List<Container> containers = service.getAllContainers();
            return ResponseEntity.ok(containers);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while returning containers", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createContainers(@RequestParam("amount") Integer amount) {
        try {
            final List<Container> containers = service.createContainer(amount);
            return ResponseEntity.ok(containers);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating containers", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/addWater")
    public ResponseEntity<?> addWater(@RequestParam("waterAmount") int amount,
                                      @RequestParam("id") Long id) {
        try {
            final List<Container> containers = service.addWater(id, amount);
            return ResponseEntity.ok(containers);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while adding water", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/connectTo")
    public ResponseEntity<?> connectTo(@RequestParam("id") Long id,
                                       @RequestParam("otherId") Long otherId) {
        try {
            final List<Container> containers = service.connectTo(id, otherId);
            return ResponseEntity.ok(containers);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while connecting containers", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
