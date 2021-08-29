package com.dailyopt.contentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @PostMapping("/")
    public ResponseEntity<Map> create(){
        Map<String, String> response = new HashMap<>();
        response.put("user", principal.getName());
        return ResponseEntity.ok().body(null);
    }
}
