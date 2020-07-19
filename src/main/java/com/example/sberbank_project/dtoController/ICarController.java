package com.example.sberbank_project.dtoController;

import simpleModel.SimpleCar;

public interface ICarController {
    void saveCar(SimpleCar car);

    void deleteCarById(long ID);

    SimpleCar getCarById(long ID);
}
