package demo_springjwt.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.repository.UserRepository;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.service.UserBookService;

@Service
public class UserBookImpl implements UserBookService{
	
	@Autowired
	private UserRepository userRepository;
		
	@Override
	public Response isRead(User user, Book book) {
		User fromDB = userRepository.findById(user.getId()).orElse(null);
		if(fromDB == null) {
			return Response.build().message("Không tìm thấy user");
		}
		
		return null;
	}

}
