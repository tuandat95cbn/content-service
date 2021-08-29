package com.dailyopt.contentservice.repo;

import com.dailyopt.contentservice.model.ContentModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    GridFsOperations operations;

    public void storeFileToGridFs(ContentModel contentModel) {

    FileMetadata metadata = new FileMetadata();
    // populate metadata
    

    operations.store(content, "filename.txt", metadata);
  }

}