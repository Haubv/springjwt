package demo_springjwt.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.dto.BookDto;
import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.entity.TypeOfBook;
import demo_springjwt.demo.repository.BookRepository;
import demo_springjwt.demo.repository.TypeOfBookRepository;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private TypeOfBookRepository typeOfBookRepository;

	@Override
	public Response createBook(Book book) {
		if(book.getName() == null || book.getTypeBook() == null) {
			Response.build().message("Không được để trống tên sách/thể loại sách");
		}
		return Response.build().ok().data(bookRepository.save(book));
	}

	@Override
	public Response updateBook(long id, Book book) {
		Book fromDB = bookRepository.findById(id).orElse(null);
		if(fromDB == null) {
			return Response.build().message("Không tìm thấy sách có id như trên");
		}
		fromDB.setName(book.getName());
		if(book.getTypeBook() != null) {
			Optional<TypeOfBook> typeBook = typeOfBookRepository.findById(book.getTypeBook().getId());
			if(typeBook.isPresent()) {
				fromDB.setTypeBook(typeBook.get());
			}
		}
		return Response.build().ok().data(BookDto.toDTO(bookRepository.save(fromDB)));
	}

	@Override
	public Response findById(long id) {
		
		return  Response.build().ok().data(bookRepository.findById(id).orElse(null));
	}

	@Override
	public Response deleteById(long id) {
		Book book = bookRepository.findById(id).orElse(null);
		if(book == null) {
			return Response.build().message("Không tìm thấy book");
		}else {
			book.setDeleted(true);
			bookRepository.save(book);
		}
		return Response.build().message("Deleted");
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = bookRepository.findAll();
		return books ;
	}



}
