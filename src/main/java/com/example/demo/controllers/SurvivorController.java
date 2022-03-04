package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.models.Location;
import com.example.demo.models.Survivor;
import com.example.demo.repositories.SurvivorRepository;
import com.example.demo.services.SurvivorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Survivor - Controller")
@RequestMapping("/api/v1")
public class SurvivorController {

    @Autowired
    SurvivorRepository survivorRepository;

    @Autowired
    SurvivorService survivorService;

    @Operation(summary = "Create Survivor", description = "creating  a new Survivor")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found list of robots") })

    @PostMapping("/survivor")
    public Survivor createSurvivor(@RequestBody Survivor survivor) {
        return survivorRepository.save(survivor);
    }

    @PutMapping("/survivors/{survivorId}")
    @Operation(summary = "update survivor byId", responses = {
            @ApiResponse(description = "get List of Infected Survivor", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Survivor.class))),
            @ApiResponse(description = "error in updating Survior details", responseCode = "400", content = @Content),

    })
    public Survivor updateOnSurvivor(@PathVariable Long contactId, @Valid @RequestBody Survivor updatedSurvivor) {
        Location location = new Location();
        return survivorRepository.findById(contactId).map(survivor -> {
            survivor.setAge(updatedSurvivor.getAge());
            survivor.setLocation(location);
            survivor.setGender(updatedSurvivor.getGender());
            return survivorRepository.save(survivor);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/surviviors/infected/percentage")
    @Operation(summary = "percentage of Infected-survivors", responses = {
            @ApiResponse(description = "calculate percentage of non-infected survivors", responseCode = "200", content = @Content(schema = @Schema(implementation = Survivor.class))),

    })

    public Long getPercentageOfinfected() {
        return (survivorService.getPercentageOfinfectedSurvivors());
    }

    @GetMapping("/noninfectedSurvivors/percentage")
    @Operation(summary = "percentage of Non-Infected", responses = {
            @ApiResponse(description = "calculate percentage of non-infected survivors", responseCode = "200", content = @Content(schema = @Schema(implementation = Survivor.class))),

    })
    public Long getPercentageOfNoninfected() {
        return survivorService.getPercentageOfNoninfectedSurvivors();
    }

    @GetMapping("/infectedSurvivors")
    @Operation(summary = "Get survivors", responses = {
            @ApiResponse(description = "get List of Infected Survivor", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Survivor.class))),
            @ApiResponse(description = "empty list of infected survivors", responseCode = "204"),
            @ApiResponse(description = "error in List of non-infected", responseCode = "500", content = @Content),

    })
    public ResponseEntity<List<Survivor>> findByInfected() {
        try {
            List<Survivor> survivors = survivorService.getInfectedSurvivors();
            if (survivors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(survivors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nonInfected/survivors")
    @Operation(summary = "Get survivors", responses = {
            @ApiResponse(description = "get Non-Infected Survivor", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Survivor.class))),
            @ApiResponse(description = "empty list of non-infected survivors", responseCode = "204"),
            @ApiResponse(description = "error in List of non-infected", responseCode = "500", content = @Content),

    })

    public ResponseEntity<List<Survivor>> findByNotInfected() {
        try {
            List<Survivor> survivors = survivorService.getNonInfectedSurvivors();
            if (survivors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(survivors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
