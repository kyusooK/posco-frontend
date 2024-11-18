package com.posco.carmanagement.s20a01.service;

import com.posco.carmanagement.s20a01.domain.driver.CreateDriverCommand;
import com.posco.carmanagement.s20a01.domain.driver.DeleteDriverCommand;
import com.posco.carmanagement.s20a01.domain.driver.Driver;
import com.posco.carmanagement.s20a01.domain.driver.UpdateDriverCommand;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class DriverController {

    private final DriverRepositoryService driverRepositoryService;

    @Autowired
    public DriverController(DriverRepositoryService driverRepositoryService) {
        this.driverRepositoryService = driverRepositoryService;
    }

    @GetMapping(path = "/drivers")
    public ResponseEntity<List<Driver>> findAll() {
        return ResponseEntity.ok(driverRepositoryService.findAll());
    }

    @PostMapping(path = "/drivers")
    public ResponseEntity<Driver> create(
        @Valid @RequestBody CreateDriverCommand command
    ) {
        return ResponseEntity.ok(driverRepositoryService.create(command));
    }

    @PatchMapping(path = "drivers/{id}")
    public ResponseEntity<Driver> update(
        @PathVariable String id,
        @Valid @RequestBody UpdateDriverCommand command
    ) {
        return ResponseEntity.ok(driverRepositoryService.update(id, command));
    }

    @DeleteMapping(path = "drivers/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        driverRepositoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
