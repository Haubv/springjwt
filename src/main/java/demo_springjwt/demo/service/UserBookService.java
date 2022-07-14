package demo_springjwt.demo.service;

import demo_springjwt.demo.entity.Book;
import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.response.Response;

public interface UserBookService {
	
	Response isRead(User user , Book book);
	
}
