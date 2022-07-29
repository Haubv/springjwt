package demo_springjwt.demo.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import demo_springjwt.demo.entity.FileDB;



public interface FileDBService {
    FileDB store(MultipartFile file) throws IOException;

    Stream<FileDB> getAllFiles();
}