package com.dailyopt.contentservice.config;




import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
@Configuration
class GridFsConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
      return "bbbbbbb-store";
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
    public ReactiveGridFsTemplate reactiveGridFsTemplate() throws Exception {
      return new ReactiveGridFsTemplate(reactiveMongoDbFactory(), mappingMongoConverter());
    }
  }