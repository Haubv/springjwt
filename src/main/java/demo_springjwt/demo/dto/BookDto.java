package demo_springjwt.demo.dto;

import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.entity.TypeOfBook;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
	
	private Long id;
	private String name;
	private Long typeBookId;
	private String typeBook;
	private String publishedDate;
	private String author;
	
	public static BookDto toDTO(Book book) {
		BookDto result = new BookDto();
		result.setId(book.getId());
		result.setName(book.getName());
		result.setTypeBook(book.getTypeBook() != null ? book.getTypeBook().getTypeName() : "");
		result.setTypeBookId(book.getTypeBook() != null ? book.getTypeBook().getId() : null);
		result.setPublishedDate(book.getPublishedDate());
		result.setAuthor(book.getAuthor());
		return result;
	}
	
	public static Book toEntity(BookDto bookDto, TypeOfBook typeBook) {
		Book result = new Book ();
		result.setId(bookDto.getId());
		result.setName(bookDto.getName());
		result.setAuthor(bookDto.getAuthor());
		result.setPublishedDate(bookDto.getPublishedDate());
		result.setTypeBook(typeBook);
		return result;
	}
}