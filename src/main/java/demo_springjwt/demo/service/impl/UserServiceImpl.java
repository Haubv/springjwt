package demo_springjwt.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.repository.UserRepository;
import demo_springjwt.demo.security.UserPrincipal;
import demo_springjwt.demo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import demo_springjwt.demo.response.Response;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    

    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserPrincipal findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != user) {
            Set<String> authorities = new HashSet<>();
            userPrincipal.setUserId(user.getId());
            userPrincipal.setUsername(user.getUsername());
            userPrincipal.setPassword(user.getPassword());
            if (null != user.getRoles()) user.getRoles().forEach(r -> {
                authorities.add(r.getName());
            });
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }

	@Override
	public boolean existsByUsername(String username) {
		if(userRepository.existsByUsername(username))
			return true;
		return false;
	}
	
	@Override 
	public Response deleteById(long id) {
		User user = userRepository.findById(id).orElse(null);
		 if (user == null) {
	          	return Response.build().message("Không tìm thấy user");
		 }else {
			 user.setDeleted(true);
			 userRepository.save(user);
		 }
	return Response.build().message("Deleted");
	}

	@Override
	public Response updateUser(long id, User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User fromDB = userRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return Response.build().message("Không tìm thấy user");
        }
        fromDB.setPassword(user.getPassword());
        fromDB.setUsername(user.getUsername());
        return Response.build().ok().data(userRepository.save(fromDB));
        
	}
	
	@Override
	public List<User> findAll() {
		List<User> user = userRepository.findAll();
		return user;
	}

}
