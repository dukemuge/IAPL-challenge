package com.example.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RobotService {

    public List<Object> getRobots() {
        String url = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
        RestTemplate restTemplate = new RestTemplate();
        Object[] robots = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(robots);

    }
}
