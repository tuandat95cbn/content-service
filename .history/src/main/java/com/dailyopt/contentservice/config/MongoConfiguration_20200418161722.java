package com.dailyopt.contentservice.config;




import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
class MongoConfiguration  {

  
  
    public @Bean MongoDbFactory mongoDbFactory() {
    return new SimpleMongoDbFactory(new MongoClient(), "content-repo");
  }
  
    
  }