package demo_springjwt.demo.service.impl;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import demo_springjwt.demo.entity.FileDB;
import demo_springjwt.demo.repository.FileDBRepository;
import demo_springjwt.demo.service.FileDBService;


@Service
public class FileDBServiceImpl implements FileDBService {
	
	@Autowired
    private FileDBRepository fileDBRepository;

    @Override
    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB image = new FileDB(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(image);
    }

    @Override
    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
