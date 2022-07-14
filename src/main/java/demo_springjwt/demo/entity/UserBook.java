package demo_springjwt.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_user_book")
@Data
public class UserBook extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	
	private boolean isRead;
	private int pageReached;

}
