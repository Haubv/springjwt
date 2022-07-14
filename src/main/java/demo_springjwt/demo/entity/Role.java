package demo_springjwt.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role")
@Data
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;

    private String name;
    
    //Map với bảng user bằng ManyToMany.
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
