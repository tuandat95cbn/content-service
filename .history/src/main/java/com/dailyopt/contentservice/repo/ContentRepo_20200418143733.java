package com.dailyopt.contentservice.repo;

public class ContentServiceImpl{
    @Autowired
    GridFsOperations operations;

    public void storeFileToGridFs() {

    FileMetadata metadata = new FileMetadata();
    // populate metadata
    Resource file = … // lookup File or Resource

    operations.store(file.getInputStream(), "filename.txt", metadata);
  }

}