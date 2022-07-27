package demo_springjwt.demo.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo_springjwt.demo.dto.TypeOfBookDto;
import demo_springjwt.demo.entity.TypeOfBook;
import demo_springjwt.demo.repository.TypeOfBookRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/book/type")
public class TypeBookController {
	
	@Autowired
	TypeOfBookRepository typeOfBookRepository;
	
	@GetMapping
	public List<TypeOfBookDto> getListType() {
		List<TypeOfBook> typeOfBook = typeOfBookRepository.findAll();
		return typeOfBook.stream().map(TypeOfBookDto::toDto).collect(Collectors.toList());
	}
}
