package demo_springjwt.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import javax.persistence.*;


@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;

//    private String name;
    
    //Map với bảng user bằng ManyToMany.
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}
