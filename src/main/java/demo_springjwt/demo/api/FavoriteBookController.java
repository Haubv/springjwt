package demo_springjwt.demo.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo_springjwt.demo.dto.FavoriteBookDto;
import demo_springjwt.demo.dto.UserDto;
import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.entity.FavoriteBook;
import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.repository.BookRepository;
import demo_springjwt.demo.repository.FavoriteBookRepository;
import demo_springjwt.demo.repository.UserRepository;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.service.FavoriteBookService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/fav")
public class FavoriteBookController extends BaseController {
	
	@Autowired
	private FavoriteBookRepository favoriteBookRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private FavoriteBookService favoriteBookService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<FavoriteBookDto> findAll() {
		Optional<User> user = userRepository.findById(this.getCurrentUser().get().getId());
		user.get().getFavoriteBooks();
		List<FavoriteBook> favoriteBooks = favoriteBookRepository.findAll();
		return favoriteBooks.stream().map(FavoriteBookDto::toDTO).collect(Collectors.toList());
	}
	
	@DeleteMapping("/{id}")
	public Response deleteFromFavorite(@PathVariable long id) {
		return favoriteBookService.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Response getBookById(@PathVariable long id) {
		Response result = favoriteBookService.findById(id);
		return result;
	}
	
	@PostMapping("/{id}")
	public Response addToFavorite(@PathVariable long id) {
		Optional<Book> book = this.bookRepository.findById(id);
		Optional<UserDto> user = this.getCurrentUser();
			Response result = favoriteBookService.addToFavorite(user.get().getId(), book.get().getId());
		return result;
		
	}
	
	@PutMapping("/{id}")
	public Response saveToFavorite(@PathVariable long id, @RequestBody FavoriteBookDto favoriteBookDto) {
		Optional<FavoriteBook> fileBook = favoriteBookRepository.findById(id);
		if(fileBook.isPresent()) {
			return Response.build().ok().data(favoriteBookService.saveFavoriteBook(favoriteBookDto));
		}
		return null;
	}

}
