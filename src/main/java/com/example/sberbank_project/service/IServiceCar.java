package com.example.sberbank_project.service;

import simpleModel.SimpleCar;

public interface IServiceCar {
    void saveCar(SimpleCar car);

    SimpleCar getCarByID(long id);

    void deleteCarById(long id);

}