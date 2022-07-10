package demo_springjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo_springjwt.demo.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);
}
