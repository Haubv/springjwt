package demo_springjwt.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.dto.UserDto;
import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.entity.UserBook;
import demo_springjwt.demo.repository.UserBookRepository;
import demo_springjwt.demo.response.Response;
import demo_springjwt.demo.service.UserBookService;

@Service
public class UserBookServiceImpl implements UserBookService{
	
	@Autowired
	private UserBookRepository userBookRepository;
		
	@Override
	public Response isRead(UserDto user, Book book) {
		if(this.userBookRepository.existsByUserIdAndBookId(user.getId(), book.getId())) {
			return null;
		}
		UserBook ub = new UserBook();
		ub.setCreatedAt(new Date());
		ub.setUserId(user != null ? user.getId() : null);
		ub.setBookId(book != null ? book.getId() : null);
		ub.setRead(true);
		return Response.build().ok().data(userBookRepository.save(ub));
	}

}
