package com.dailyopt.contentservice.repo;

import java.util.HashMap;
import java.util.Map;

import com.dailyopt.contentservice.model.ContentModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    GridFsOperations operations;

    public String storeFileToGridFs(ContentModel contentModel) {

        Map<String,String> metadata = new HashMap<>();
        metadata.put("upload_file_name", contentModel.getFile().getOriginalFilename())

        operations.store(contentModel.getFile().getInputStream(), contentModel.getId(), metadata);
    }

}