package demo_springjwt.demo.service;

import java.util.List;
import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.response.Response;

public interface BookService {
	
	Response createBook(Book book);
	
	Response updateBook(long id , Book book);
	
	Response findById(long id);
	
	Response deleteById(long id);
	
	List<Book> findAll();	
	
}
