package demo_springjwt.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo_springjwt.demo.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	  	Book findByName(String name);
	  	Optional<Book> findById(Long id);
	    boolean existsByName(String name);
	    Optional<Book> findByFileBookId(Long id);
}
