package demo_springjwt.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import demo_springjwt.demo.entity.FileBook;
import demo_springjwt.demo.repository.FileBookRepository;
import demo_springjwt.demo.service.FileBookService;


@Service
public class FileBookServiceImpl implements FileBookService {

	@Autowired
	FileBookRepository fileBookRepository;
	
	@Value("${upload.path}")
    private String fileUpload;

	@Override
	public FileBook saveFileBook(MultipartFile file, String desc) {
		if(file.isEmpty()) {
			return null;
		}
		FileBook result = new FileBook();
		String path = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(this.fileUpload + path));
            result.setPath(path);
            result.setDescription(desc);
            fileBookRepository.save(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return result;
	}

	@Override
	public File loadFileBook(long id) {
		Optional<FileBook> fileBook = fileBookRepository.findById(id);
		if (fileBook.isEmpty()) {
			return null;
		}
		Path tireFolder = Paths.get(this.fileUpload);
        Path destination = tireFolder.resolve(fileBook.get().getPath());
        
        return destination.toFile().exists() ? destination.toFile() : null;
	}

}
