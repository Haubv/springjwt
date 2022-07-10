package demo_springjwt.demo.service;

import demo_springjwt.demo.entity.Token;

public interface TokenService {

    Token createToken(Token token);

    Token findByToken(String token);
}
