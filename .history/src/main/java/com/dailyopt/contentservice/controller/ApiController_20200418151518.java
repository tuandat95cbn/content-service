package com.dailyopt.contentservice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dailyopt.contentservice.model.ContentModel;
import com.dailyopt.contentservice.repo.ContentService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private ContentService contentService;

    @PostMapping("/")
    public ResponseEntity<Map> create(ContentModel model) {
        ObjectId id;
        try {
             id= contentService.storeFileToGridFs(model);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.ok().body(null);
        }
        Map<String, String> response = new HashMap<>();
        response.put("status", "SUCESS");
        response.put("id", id.toHexString());
        return ResponseEntity.ok().body(response);
    }
}
