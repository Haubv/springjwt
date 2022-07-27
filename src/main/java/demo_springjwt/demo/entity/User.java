package demo_springjwt.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", 
uniqueConstraints = { 
  @UniqueConstraint(columnNames = "username"),
  @UniqueConstraint(columnNames = "email") 
})
@Data
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(max = 120)
	  private String password;
	 
	  public User() {
	  }
	  
	  public User(String username, String email, String password) {
		    this.username = username;
		    this.email = email;
		    this.password = password;
		  }

    
    
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(  name = "user_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();
    
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private Set<UserBook> userBooks = new HashSet<>();
    
    
}
