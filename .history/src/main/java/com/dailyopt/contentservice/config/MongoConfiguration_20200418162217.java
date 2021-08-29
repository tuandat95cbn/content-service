package com.dailyopt.contentservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
class MongoConfiguration extends AbstractMongoClientConfiguration {

  @Override
  protected String getDatabaseName() {
    return "database";
  }

  @Override
  public MongoClient mongoClient() {
    return MongoClients.create("mongodb://localhost:27017/?replicaSet=rs0&w=majority");
  }

}