package demo_springjwt.demo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_book")
@Data
public class Book extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	//Map với bảng typeBook bằng ManyToOne.
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_book_id")
	private TypeOfBook typeBook;
	
	//Map với bảng user bằng ManyToMany.
	@ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
	private List<User> users;
	
}