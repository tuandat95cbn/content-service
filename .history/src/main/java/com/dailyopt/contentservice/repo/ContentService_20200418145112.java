package com.dailyopt.contentservice.repo;

import java.io.IOException;

import com.dailyopt.contentservice.model.ContentModel;

public interface ContentService {
    public ObjectId storeFileToGridFs(ContentModel contentModel)  throws IOException;

}