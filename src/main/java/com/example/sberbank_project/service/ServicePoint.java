package com.example.sberbank_project.service;

import EntityConverters.PointMapper;
import com.example.sberbank_project.model.Point;
import com.example.sberbank_project.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleModel.SimplePoint;

import java.util.Optional;

@Service
public class ServicePoint implements IServicePoint {

    @Autowired
    private PointRepository repositoryPoints;

    @Override
    public SimplePoint getPointByID(long id) {
        Optional<Point> optional = repositoryPoints.findById(id);
        Point point = null;
        if (optional.isPresent()) {
            point = optional.get();
        } else {
            throw new RuntimeException("Car not found");
        }

        return PointMapper.INSTANCE.toDTO(point);
    }
}