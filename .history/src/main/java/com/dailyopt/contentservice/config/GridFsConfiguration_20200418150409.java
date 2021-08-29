package com.dailyopt.contentservice.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;

public class GridFsConfiguration extends AbstractReactiveMongoConfiguration {

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
  // return "com.oreilly.springdata.mongodb";
  // }

  @Bean
  public ReactiveGridFsTemplate reactiveGridFsTemplate() {
    try {
      return new ReactiveGridFsTemplate(reactiveMongoDbFactory(), mappingMongoConverter());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    }
  }