package demo_springjwt.demo.service;

import java.util.List;

import demo_springjwt.demo.dto.BookDto;
//import demo_springjwt.demo.entity.Book;
//import demo_springjwt.demo.entity.FileBook;
import demo_springjwt.demo.response.Response;

public interface BookService {
	
	Response createBook(BookDto bookDto);
	
	Response updateBook(long id , BookDto bookDto);
	
	Response findById(long id);
	
	Response deleteById(long id);
	
	List<BookDto> findAll();	
	
	BookDto saveBook(BookDto bookDto);

}
