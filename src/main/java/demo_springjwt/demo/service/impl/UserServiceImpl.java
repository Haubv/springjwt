package demo_springjwt.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.repository.UserRepository;
import demo_springjwt.demo.security.UserPrincipal;
import demo_springjwt.demo.service.UserService;

import java.util.HashSet;
import java.util.Set;

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

}
