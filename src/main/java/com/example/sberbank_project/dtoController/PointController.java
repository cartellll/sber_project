package com.example.sberbank_project.dtoController;

import com.example.sberbank_project.service.IServicePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simpleModel.SimpleCar;

@Component
public class PointController implements IPointController {

    @Autowired
    private IServicePoint servicePoint;

    @Override
    public void setCarPointById(long pointID, SimpleCar car) {
        car.setPoint(servicePoint.getPointByID(pointID));
    }

}
