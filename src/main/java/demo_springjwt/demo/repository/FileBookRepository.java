package demo_springjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo_springjwt.demo.entity.FileBook;


@Repository
public interface FileBookRepository extends JpaRepository<FileBook , Long> {
	
}
