package com.dailyopt.contentservice.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ContentModel {
    String id;
    MultipartFile file;

}