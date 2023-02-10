package com.example.facebookapi.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
    private final UserRepository userRepository;
    public SecurityController(UserRepository userRepository){
       this.userRepository = userRepository;
    }



    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user){
        try {

            //user.setPassword();
            return ResponseEntity.ok(userRepository.save(user));
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginBody body){
        try {
            return ResponseEntity.ok(userRepository.getUserByEmail(body.getEmail()));
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
