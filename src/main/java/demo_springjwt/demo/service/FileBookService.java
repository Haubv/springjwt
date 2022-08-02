package demo_springjwt.demo.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import demo_springjwt.demo.entity.FileBook;

public interface FileBookService {
	FileBook saveFileBook(MultipartFile file, String desc);
	public File loadFileBook(long id);
}
