package demo_springjwt.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Data
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String username;

    private String password;
    
    //Relation với bảng role.
    
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();
       
    //Relation với bảng book.
    
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserBook> userBooks = new HashSet<>();
}
