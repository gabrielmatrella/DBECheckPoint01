package br.com.healthtrack.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> getHealthStatus() {
        return ResponseEntity.ok("{\"status\": \"Im healthy\"}");
    }

}
