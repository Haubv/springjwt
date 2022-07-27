package demo_springjwt.demo.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo_springjwt.demo.dto.BookDto;
import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.repository.BookRepository;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.service.BookService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public Response createBook(@RequestBody BookDto bookDto) {
		return Response.build().ok().data(bookService.createBook(bookDto));
	}
	
	@PostMapping("/{id}")
	public Response updateBook(@PathVariable long id, @RequestBody BookDto bookDto) {
		return Response.build().ok().data(bookService.updateBook(id, bookDto));
	}
	
	@GetMapping
	public List<BookDto> findAll() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(BookDto::toDTO).collect(Collectors.toList());
	}
	
	@DeleteMapping("/{id}")
	public Response deleteById(@PathVariable long id) {
		return bookService.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Response getBookById(@PathVariable long id) {
		Response result = bookService.findById(id);
		return result;
	}
}
