package com.dailyopt.contentservice.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;

class GridFsConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
      return "e-store";
    }
  
    @Override
    public MongoClient reactiveMongoClient() {
      return MongoClients.create();
    }
  
    // @Override
    // protected String getMappingBasePackage() {
    //   return "com.oreilly.springdata.mongodb";
    // }
  
    @Bean
    public ReactiveGridFsTemplate reactiveGridFsTemplate() {
      return new ReactiveGridFsTemplate(reactiveMongoDbFactory(), mappingMongoConverter());
    }
  }