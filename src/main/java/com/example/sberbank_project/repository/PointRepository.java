package com.example.sberbank_project.repository;

import com.example.sberbank_project.model.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends CrudRepository<Point, Long> {

}