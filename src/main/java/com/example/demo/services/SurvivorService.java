package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Survivor;
import com.example.demo.repositories.SurvivorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurvivorService {

    @Autowired
    SurvivorRepository survivorRepository;

    public Long getPercentageOfNoninfectedSurvivors() {
        List<Survivor> nonInfectedSurvivor = survivorRepository.findByInfected(false);
        long nonInfectedSurvivors = nonInfectedSurvivor.size();
        long totalSurvivors = survivorRepository.count();
        return (nonInfectedSurvivors / totalSurvivors * 100);
    }

    public Long getPercentageOfinfectedSurvivors() {
        List<Survivor> infectedSurvivor = survivorRepository.findByInfected(true);
        long infectedSurvivors = infectedSurvivor.size();
        long totalSurvivors = survivorRepository.count();
        return (infectedSurvivors / totalSurvivors * 100);
    }

    // Find List of Infected survivors
    public List<Survivor> getInfectedSurvivors() {
        return (survivorRepository.findByInfected(true));
    }

    // Find List of Non- Infected survivors
    public List<Survivor> getNonInfectedSurvivors() {
        return (survivorRepository.findByInfected(false));
    }

}
