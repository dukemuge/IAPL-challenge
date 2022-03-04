package com.example.demo.controllers;

import java.util.List;
import com.example.demo.models.Robot;
import com.example.demo.services.RobotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Robot -Controller")
public class RobotController {

    @Autowired
    RobotService robotService;

    @GetMapping(value = "/robots", produces = "application/json")
    @Operation(summary = "Get robots", responses = {
            @ApiResponse(description = "get fetch list of robots given url", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Robot.class))),

    })

    public List<Object> getAllRobots() {
        return robotService.getRobots();

    }

}
