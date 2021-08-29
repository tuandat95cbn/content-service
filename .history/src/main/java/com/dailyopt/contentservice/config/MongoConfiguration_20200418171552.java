package com.dailyopt.contentservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
class MongoConfiguration extends AbstractMongoClientConfiguration {
  @Autowired
    private Environment env;
  @Override
  protected String getDatabaseName() {
    return "content_repo";
  }

  @Override
  public MongoClient mongoClient() {
    return MongoClients.create("mongodb://localhost:27017/");
  }

}