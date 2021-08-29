package com.dailyopt.contentservice.repo;

import java.io.IOException;

import com.dailyopt.contentservice.model.ContentModel;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsResource;

public interface ContentService {
    public ObjectId storeFileToGridFs(ContentModel contentModel)  throws IOException;
    public GridFsResource getById(String id);
}