package com.dailyopt.contentservice.repo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dailyopt.contentservice.model.ContentModel;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
  @Autowired
  GridFsOperations operations;

  public ObjectId storeFileToGridFs(ContentModel contentModel) throws IOException {
    Map<String, String> metadata = new HashMap<>();
    metadata.put("upload_file_name", contentModel.getFile().getOriginalFilename());
    return operations.store(contentModel.getFile().getInputStream(), contentModel.getId(), metadata);
  }

  public GridFSFile getById(String id) {
      return operations.findOne(Query.query(Criteria.where("_id").is(id)));
    }

}