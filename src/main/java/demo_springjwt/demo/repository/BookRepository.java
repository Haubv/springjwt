package demo_springjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo_springjwt.demo.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	  	Book findByName(String name);
	    boolean existsByName(String name);
}
