package com.dailyopt.contentservice.repo;

import com.dailyopt.contentservice.model.ContentModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    GridFsOperations operations;

    public String storeFileToGridFs(ContentModel contentModel) {

    FileMetadata metadata = new FileMetadata();

    operations.store(contentModel.getFile().getInputStream(),contentModel.getId(),metadata);
  }

}