package com.example.sberbank_project.service;

import EntityConverters.CarMapper;
import com.example.sberbank_project.model.Car;
import com.example.sberbank_project.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleModel.SimpleCar;

import java.util.Optional;

@Service
public class ServiceCar implements IServiceCar {

    @Autowired
    private CarRepository repositoryCars;


    @Override
    public void saveCar(SimpleCar car) {
        repositoryCars.save(CarMapper.INSTANCE.toEntity(car));
    }

    @Override
    public SimpleCar getCarByID(long id) {
        Optional<Car> optional = repositoryCars.findById(id);
        Car car = null;
        if (optional.isPresent()) {
            car = optional.get();
        } else {
            throw new RuntimeException("Car not found");
        }
        return CarMapper.INSTANCE.toDTO(car);
    }

    @Override
    public void deleteCarById(long id) {
        repositoryCars.deleteById(id);
    }
}

