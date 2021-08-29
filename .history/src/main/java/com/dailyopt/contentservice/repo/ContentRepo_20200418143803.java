package com.dailyopt.contentservice.repo;

import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    GridFsOperations operations;

    public void storeFileToGridFs() {

    FileMetadata metadata = new FileMetadata();
    // populate metadata
    Resource file = … // lookup File or Resource

    operations.store(file.getInputStream(), "filename.txt", metadata);
  }

}