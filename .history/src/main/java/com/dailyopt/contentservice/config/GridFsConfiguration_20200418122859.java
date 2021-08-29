package com.dailyopt.contentservice.config;

class GridFsConfiguration extends AbstractReactiveMongoConfiguration {

    // … further configuration omitted
  
    @Bean
    public ReactiveGridFsTemplate reactiveGridFsTemplate() {
      return new ReactiveGridFsTemplate(reactiveMongoDbFactory(), mappingMongoConverter());
    }
  }