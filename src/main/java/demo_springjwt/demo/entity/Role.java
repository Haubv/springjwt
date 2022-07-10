package demo_springjwt.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;

    private String name;
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
