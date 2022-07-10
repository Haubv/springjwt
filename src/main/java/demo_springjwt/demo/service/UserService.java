package demo_springjwt.demo.service;

import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.security.UserPrincipal;

public interface UserService {
    User createUser(User user);

    UserPrincipal findByUsername(String username);
    
    boolean existsByUsername(String username);
}
