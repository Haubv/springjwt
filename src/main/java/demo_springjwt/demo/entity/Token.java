package demo_springjwt.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_token")
@Data
public class Token extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(length = 1000)
    private String token;

    private Date tokenExpDate;
}
