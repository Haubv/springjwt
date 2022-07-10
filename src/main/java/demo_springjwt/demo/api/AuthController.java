package demo_springjwt.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo_springjwt.demo.entity.Token;
import demo_springjwt.demo.entity.User;
import demo_springjwt.demo.security.JwtUtil;
import demo_springjwt.demo.security.UserPrincipal;
import demo_springjwt.demo.service.TokenService;
import demo_springjwt.demo.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
         if (userService.existsByUsername(user.getUsername())) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username đã tồn tại");
         }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        UserPrincipal userPrincipal = userService.findByUsername(user.getUsername());
        if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));
        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);
        return ResponseEntity.ok(token.getToken());
    }
    
    
    @GetMapping("/free")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("free");
    }
    
    @GetMapping("/admin")
    public ResponseEntity<?> admin() {
        return ResponseEntity.ok("Admin");
    }
    @GetMapping("/author")
    public ResponseEntity<?> author() {
        return ResponseEntity.ok("author");
    }
    
 
    @GetMapping("/user")
    public ResponseEntity<?> user() {
        return ResponseEntity.ok("user");
    }
    @GetMapping("/editor")
    public ResponseEntity<?> editor() {
        return ResponseEntity.ok("editor");
    }
    
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/userPA")
    public ResponseEntity<?> userPA() {
        return ResponseEntity.ok("userPA");
    }
}
