package demo_springjwt.demo.service;

import java.util.List;

import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.security.UserPrincipal;

public interface UserService {
	
    User createUser(User user);
    
    UserPrincipal findByUsername(String username);    
    
    Response updateUser(long id ,User user); 
    
    boolean existsByUsername(String username);   
    
    Response deleteById(long id);
    
    List<User> findAll();
}
