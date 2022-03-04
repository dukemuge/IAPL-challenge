package com.example.demo.repositories;

import com.example.demo.models.Robot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends CrudRepository<Robot, Long> {

}
