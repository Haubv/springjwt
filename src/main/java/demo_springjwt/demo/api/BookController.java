package demo_springjwt.demo.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo_springjwt.demo.dto.BookDto;
import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public Response createBook(@RequestBody Book book) {
		return Response.build().ok().data(bookService.createBook(book));
	}
	
	@PostMapping("/{id}")
	public Response updateBook(@PathVariable long id, @RequestBody Book book) {
		return Response.build().ok().data(bookService.updateBook(id, book));
	}
	
	@GetMapping
	public List<BookDto> findAll() {
		List<BookDto> books = bookService.findAll().stream().map(BookDto::toDTO).collect(Collectors.toList());
		return books;
	}
	
	@DeleteMapping("/{id}")
	public Response deleteById(@PathVariable long id) {
		return bookService.deleteById(id);
	}
}
