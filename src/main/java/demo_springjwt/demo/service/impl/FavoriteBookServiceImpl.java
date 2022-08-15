package demo_springjwt.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.dto.FavoriteBookDto;
import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.entity.FavoriteBook;
import demo_springjwt.demo.entity.FileBook;
import demo_springjwt.demo.entity.TypeOfBook;
import demo_springjwt.demo.repository.BookRepository;
import demo_springjwt.demo.repository.FavoriteBookRepository;
import demo_springjwt.demo.repository.FileBookRepository;
import demo_springjwt.demo.repository.TypeOfBookRepository;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.service.FavoriteBookService;


@Service
public class FavoriteBookServiceImpl implements FavoriteBookService {
	
	@Autowired
	private FavoriteBookRepository favoriteBookRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private TypeOfBookRepository typeOfBookRepository;
	
	@Autowired
	private FileBookRepository fileBookRepository;

	@Override
	public Response findById(long id) {
		Optional<FavoriteBook> favoriteBook = favoriteBookRepository.findById(id);
		if(favoriteBook.isEmpty()) {
			return Response.build().message("Không tìm thấy sách có id như trên");
		}
		return  Response.build().ok().data(FavoriteBookDto.toDTO(favoriteBook.get()));
	}

	@Override
	public Response deleteById(long id) {
		FavoriteBook favoriteBook = favoriteBookRepository.findById(id).orElse(null);
		if(favoriteBook == null) {
			return Response.build().message("Không tìm thấy book");
		}else {
			favoriteBook.setDeleted(true);
			favoriteBookRepository.save(favoriteBook);
		}
		return Response.build().message("Deleted");
	}

	@Override
	public List<FavoriteBookDto> findAll() {
		List<FavoriteBook> favoriteBooks = favoriteBookRepository.findAll();
		return favoriteBooks.stream().map(FavoriteBookDto::toDTO).collect(Collectors.toList());
	}

	@Override
	public Response addToFavorite(long userId, long bookId) {
		if (favoriteBookRepository.existsByIdAndUserId(bookId, userId)) {
			return null;
		}
		FavoriteBook fb = new FavoriteBook();
		Optional<Book> book = bookRepository.findById(bookId);
			fb.setUserId(userId);
			fb.setBookId(book.get().getId());
			fb.setName(book.get().getName());
			fb.setAuthor(book.get().getAuthor());
			fb.setPublishedDate(book.get().getPublishedDate());
			fb.setTypeBook(book.get().getTypeBook());
			fb.setFileBook(book.get().getFileBook());
			fb.setFileName(book.get().getFileName());
			fb.setAdded(true);
			Response.build().data(favoriteBookRepository.save(fb));
			return Response.build().message("Added To Favorite.");
	}

	@Override
	public FavoriteBookDto saveFavoriteBook(FavoriteBookDto favoriteBookDto) {
		FavoriteBook favoriteBook = new FavoriteBook();
		TypeOfBook typeBook = typeOfBookRepository.findById(favoriteBookDto.getTypeBookId()).orElse(null);
		FileBook fileBook = fileBookRepository.findById(favoriteBookDto.getFileBookId()).orElse(null);
		favoriteBook = favoriteBookRepository.save(FavoriteBookDto.toEntity(favoriteBookDto, typeBook, fileBook));
		return FavoriteBookDto.toDTO(favoriteBook);
	}

}
