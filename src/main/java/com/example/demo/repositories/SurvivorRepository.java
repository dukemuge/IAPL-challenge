package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Survivor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends CrudRepository<Survivor, Long> {

    List<Survivor> findByInfected(boolean infected);

}
