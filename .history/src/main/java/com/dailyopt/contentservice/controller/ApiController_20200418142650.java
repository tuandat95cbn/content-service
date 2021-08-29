package com.dailyopt.contentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @PostMapping("/")
    public ResponseEntity<Map> create(){
        return ResponseEntity.ok().body(null);
    }
}
