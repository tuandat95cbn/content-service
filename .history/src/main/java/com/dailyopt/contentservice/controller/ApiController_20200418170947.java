package com.dailyopt.contentservice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dailyopt.contentservice.model.ContentModel;
import com.dailyopt.contentservice.repo.ContentService;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;


@RestController
@Log
public class ApiController {
    @Autowired
    private ContentService contentService;

    @PostMapping("/")
    public ResponseEntity<Map> create(ContentModel model) {
        ObjectId id;
        try {
            id = contentService.storeFileToGridFs(model);
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

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> get(@PathVariable String id) {
        log.info("get data for "+id);
        try {
            GridFSFile content = contentService.getById(id);
            HttpHeaders headers = new HttpHeaders();

            headers.setContentLength(content.getLength());

            headers.setContentDispositionFormData("attachment",
                    content.getMetadata().get("upload_file_name").toString());

            InputStreamResource isr = new InputStreamResource(content.());
            return new ResponseEntity<InputStreamResource>(isr, headers, HttpStatus.OK);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
