package demo_springjwt.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBook extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private long bookId;
	private boolean isRead;
	private int pageReached;
	private long userId;

}
