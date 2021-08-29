package com.dailyopt.contentservice.controller;

import java.util.HashMap;
import java.util.Map;

import com.dailyopt.contentservice.model.ContentModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    
    @PostMapping("/")
    public ResponseEntity<Map> create(ContentModel model){

        Map<String, String> response = new HashMap<>();
        response.put("status", "SUCESS");
        return ResponseEntity.ok().body(response);
    }
}
