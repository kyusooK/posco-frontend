package com.posco.carmanagement.s20a01.service;

import com.posco.carmanagement.s20a01.domain.driver.CreateDriverCommand;
import com.posco.carmanagement.s20a01.domain.driver.DeleteDriverCommand;
import com.posco.carmanagement.s20a01.domain.driver.Driver;
import com.posco.carmanagement.s20a01.domain.driver.DriverRepository;
import com.posco.carmanagement.s20a01.domain.driver.UpdateDriverCommand;
import com.posco.carmanagement.s20a01.domain.driver.mybatis.DriverMapper;
import com.posco.carmanagement.s20a01.domain.driver.mybatis.DriverMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class DriverRepositoryService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverRepositoryService(
        DriverRepository driverRepository,
        DriverMapper driverMapper
    ) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public Driver create(CreateDriverCommand command) {
        Driver driver = new Driver();
        driver.setDriverEmpNo(command.getDriverEmpNo());
        driver.setName(command.getName());
        driver.setCompanyCode(command.getCompanyCode());
        driver.setWorksCode(command.getWorksCode());
        return driverRepository.save(driver);
    }

    public Driver update(String id, UpdateDriverCommand command) {
        Driver existing = findById(id);
        if (command.getRetirementFlag() != null) {
            existing.setRetirementFlag(command.getRetirementFlag());
        }
        if (command.getRetiredDate() != null) {
            existing.setRetiredDate(command.getRetiredDate());
        }
        if (command.getImage() != null) {
            existing.setImage(command.getImage());
        }
        return driverRepository.save(existing);
    }

    public void delete(String id) {
        Driver driver = findById(id);
        driverRepository.delete(driver);
    }

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Driver findById(String id) {
        return driverRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Driver not found"
                )
            );
    }

    //// mybatis
    private Driver convertToEntity(DriverMybatisEntity mybatisEntity) {
        Driver entity = new Driver();
        return entity;
    }

    private DriverMybatisEntity convertToMybatisEntity(Driver entity) {
        DriverMybatisEntity mybatisEntity = new DriverMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<Driver> findAllByMapper() {
    //     return mybatisMapper.selectDriverList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public Driver findByIdMapper(String id) {
    //     DriverMybatisEntity mybatisEntity = mybatisMapper.selectDriver(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}
