package demo_springjwt.demo.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FileBook extends BaseEntity {
		
	private static final long serialVersionUID = 1L;
	
	private String path;
	private String description;
	

}
