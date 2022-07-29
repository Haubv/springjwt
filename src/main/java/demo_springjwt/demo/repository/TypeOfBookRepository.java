package demo_springjwt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo_springjwt.demo.entity.TypeOfBook;

@Repository
public interface TypeOfBookRepository extends JpaRepository<TypeOfBook, Long> {
	
	List<TypeOfBook> findAll();

}
