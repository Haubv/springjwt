package demo_springjwt.demo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_type_book")	//Bảng typeBook.
@Data
public class TypeOfBook extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String typeName;
	
	//Map với bảng book bằng OneToMany.
	@OneToMany(mappedBy = "typeBook")
	private List<Book> books;
	
}
