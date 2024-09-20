package com.example.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users registerUser(Users users)
    {
        return userRepository.save(users);
    }

    public ResponseEntity<?> loginUser(String email, String password)
    {
        Optional<Users>usersOptional = userRepository.findByEmailAndPassword(email,password);
        if(usersOptional.isPresent()){
            return new ResponseEntity<>("User Login Successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Enter valid email & password",HttpStatus.BAD_REQUEST);
        }
    }
}

