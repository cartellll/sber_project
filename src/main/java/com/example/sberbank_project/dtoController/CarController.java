package com.example.sberbank_project.dtoController;

import com.example.sberbank_project.service.IServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simpleModel.SimpleCar;

@Component
public class CarController implements ICarController {

    @Autowired
    private IServiceCar serviceCar;

    @Override
    public void saveCar(SimpleCar car) {
        serviceCar.saveCar(car);
    }

    @Override
    public SimpleCar getCarById(long ID) {
        return serviceCar.getCarByID(ID);
    }

    @Override
    public void deleteCarById(long ID) {
        serviceCar.deleteCarById(ID);
    }
}
