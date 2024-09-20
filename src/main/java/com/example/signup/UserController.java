package com.example.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/signup")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser (@RequestBody Users users){
        try{
            userService.registerUser(users);
            return ResponseEntity.ok("User Registered Succeefully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestParam String email,@RequestParam String password)
    {
        try{
            return userService.loginUser(email,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
