package com.example.projectboard.Controller;

import com.example.projectboard.JWT.VerifyJWT;
import com.example.projectboard.Model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    public static String home(@RequestHeader HttpHeaders httpHeaders) {
        User user2 = new User();
        user2.setEmail("johncena@wwe.com");
        user2.setPassword("johncena");
        String token = httpHeaders.get("Authorization").get(0);
        boolean isValidToken = VerifyJWT.tokenVerify(user2.getEmail(), user2.getPassword(), token);
        if (isValidToken) {
            return "Welcome to valid Home";
        }
        return "Please check your credentials";
    }
}
