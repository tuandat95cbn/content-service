package com.dailyopt.contentservice.controller;

import java.io.IOException;
import java.io.InputStream;

import com.dailyopt.contentservice.model.ContentModel;
import com.dailyopt.contentservice.repo.ContentService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
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
    public ResponseEntity<String> create(ContentModel model) {
        ObjectId id;
        try {
            id = contentService.storeFileToGridFs(model);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.ok().body("/" + id.toHexString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> get(@PathVariable String id) {
        log.info("get data for " + id);
        try {
            GridFsResource content = contentService.getById(id);
            if (content != null) {
                InputStream inputStream = content.getInputStream();
                byte[] data = new byte[inputStream.available()];
                inputStream.read(data);

                return new ResponseEntity<>(data, null, HttpStatus.OK);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
