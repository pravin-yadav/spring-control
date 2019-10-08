package com.example.projectboard.Controller;

import com.example.projectboard.Model.User;
import com.example.projectboard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Iterable<User> getAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        User getUserById = userService.findUserById(userId);
        return new ResponseEntity<>(getUserById, HttpStatus.OK);
    }

    @PostMapping("/user/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        for (User user1 : userService.findAllUser()) {
            if (user1.getEmail().contains(user.getEmail())) {
                return new ResponseEntity<>("Email Exist!!!", HttpStatus.BAD_REQUEST);
            }
        }

        if (user.getPassword().equals(user.getConfirmPassword())) {
            user.setPassword(bCryptEncoder.encode(user.getPassword()));
            user.setConfirmPassword(bCryptEncoder.encode(user.getConfirmPassword()));
            User userCreated = userService.createOrUpdateUser(user);
            return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Password and ConfirmPassword doesn't match!!!", HttpStatus.OK);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody User user) {
        for (User user1 : userService.findAllUser()) {
            if (user1.getEmail().contains(user.getEmail()) && bCryptEncoder.matches(user.getPassword(), user1.getPassword())) {
                return new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Logged Failed", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/user/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @Valid @RequestBody User user) {
        User usersId = userService.findUserById(userId);
        if (usersId != null) {
            usersId.setUsername(user.getUsername());
            usersId.setFirstName(user.getFirstName());
            usersId.setLastName(user.getLastName());
            usersId.setEmail(user.getEmail());
            usersId.setMobile(user.getMobile());
            usersId.setPassword(user.getPassword());
            usersId.setConfirmPassword(user.getConfirmPassword());
            User updatedUser = userService.createOrUpdateUser(usersId);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(String.format("User with Id %s doesn't exist!!!", userId), HttpStatus.NOT_MODIFIED);

        }
    }

    @DeleteMapping("/user/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(String.format("User with Id %d is deleted Successfully", userId), HttpStatus.OK);
    }
}

