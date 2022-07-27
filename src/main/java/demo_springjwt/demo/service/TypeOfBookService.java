package demo_springjwt.demo.service;

import java.util.List;

import demo_springjwt.demo.dto.TypeOfBookDto;

public interface TypeOfBookService {
	List<TypeOfBookDto> findAllType();
}
