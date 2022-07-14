package demo_springjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo_springjwt.demo.entity.TypeOfBook;

public interface TypeOfBookRepository extends JpaRepository<TypeOfBook, Long> {
	
}
