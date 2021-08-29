package com.dailyopt.contentservice.config;




import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
class MongoConfiguration extends AbstractMongoClientConfiguration {

  
  
    public @Bean MongoClient mongoClient() {
       return new MongoClient("localhost");
   }
  
    
  }