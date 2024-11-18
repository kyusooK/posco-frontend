package com.posco.carmanagement.s20a01.service;

import com.posco.carmanagement.s20a01.domain.car.Car;
import com.posco.carmanagement.s20a01.domain.car.CarRepository;
import com.posco.carmanagement.s20a01.domain.car.CreateCarCommand;
import com.posco.carmanagement.s20a01.domain.car.DeleteCarCommand;
import com.posco.carmanagement.s20a01.domain.car.UpdateCarCommand;
import com.posco.carmanagement.s20a01.domain.car.mybatis.CarMapper;
import com.posco.carmanagement.s20a01.domain.car.mybatis.CarMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class CarRepositoryService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarRepositoryService(
        CarRepository carRepository,
        CarMapper carMapper
    ) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Car create(CreateCarCommand command) {
        Car car = new Car();
        car.setResourceId(command.getResourceId());
        car.setCarrierNo(command.getCarrierNo());
        car.setWorksCode(command.getWorksCode());
        car.setCompanyCode(command.getCompanyCode());
        car.setCarType(command.getCarType());
        car.setCarModel(command.getCarModel());
        car.setUsage(command.getUsage());
        car.setFuelFlag(command.getFuelFlag());
        car.setPartCompanyCd(command.getPartCompanyCd());
        car.setOwnerTypeCode(command.getOwnerTypeCode());
        return carRepository.save(car);
    }

    public Car update(Long id, UpdateCarCommand command) {
        Car existing = findById(id);
        if (command.getCarType() != null) {
            existing.setCarType(command.getCarType());
        }
        if (command.getCarModel() != null) {
            existing.setCarModel(command.getCarModel());
        }
        if (command.getUsage() != null) {
            existing.setUsage(command.getUsage());
        }
        if (command.getFuelFlag() != null) {
            existing.setFuelFlag(command.getFuelFlag());
        }
        if (command.getDriverEmpNo() != null) {
            existing.setDriverEmpNo(command.getDriverEmpNo());
        }
        if (command.getUserName() != null) {
            existing.setUserName(command.getUserName());
        }
        if (command.getDriverIds() != null) {
            existing.setDriverIds(command.getDriverIds());
        }
        return carRepository.save(existing);
    }

    public void delete(Long id) {
        Car car = findById(id);
        carRepository.delete(car);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long id) {
        return carRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Car not found"
                )
            );
    }

    //// mybatis
    private Car convertToEntity(CarMybatisEntity mybatisEntity) {
        Car entity = new Car();
        return entity;
    }

    private CarMybatisEntity convertToMybatisEntity(Car entity) {
        CarMybatisEntity mybatisEntity = new CarMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<Car> findAllByMapper() {
    //     return mybatisMapper.selectCarList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public Car findByIdMapper(Long id) {
    //     CarMybatisEntity mybatisEntity = mybatisMapper.selectCar(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}
