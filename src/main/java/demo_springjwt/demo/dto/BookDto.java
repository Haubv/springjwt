package demo_springjwt.demo.dto;

import demo_springjwt.demo.entity.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
private Long id;
	
	private String name;
	private String type;
	
	public static BookDto toDTO(Book book) {
		BookDto result = new BookDto();
		result.setId(book.getId());
		result.setName(book.getName());
		result.setType(book.getTypeBook().getTypeName());
		return result;
	}
}