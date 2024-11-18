package com.posco.carmanagement.s20a01.service;

import com.posco.carmanagement.s20a01.domain.car.Car;
import com.posco.carmanagement.s20a01.domain.car.CreateCarCommand;
import com.posco.carmanagement.s20a01.domain.car.DeleteCarCommand;
import com.posco.carmanagement.s20a01.domain.car.UpdateCarCommand;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class CarController {

    private final CarRepositoryService carRepositoryService;

    @Autowired
    public CarController(CarRepositoryService carRepositoryService) {
        this.carRepositoryService = carRepositoryService;
    }

    @GetMapping(path = "/cars")
    public ResponseEntity<List<Car>> findAll() {
        return ResponseEntity.ok(carRepositoryService.findAll());
    }

    @PostMapping(path = "/cars")
    public ResponseEntity<Car> create(
        @Valid @RequestBody CreateCarCommand command
    ) {
        return ResponseEntity.ok(carRepositoryService.create(command));
    }

    @PatchMapping(path = "cars/{id}")
    public ResponseEntity<Car> update(
        @PathVariable Long id,
        @Valid @RequestBody UpdateCarCommand command
    ) {
        return ResponseEntity.ok(carRepositoryService.update(id, command));
    }

    @DeleteMapping(path = "cars/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carRepositoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
