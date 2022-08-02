package demo_springjwt.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_book_id")
	private TypeOfBook typeBook;
	private String publishedDate;
	private String author;
	private String fileName;
	
	@OneToOne
    @JoinColumn(name = "file_book_id")
    private FileBook fileBook;
	
	

		//	@ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
		//	private List<User> users;	
}