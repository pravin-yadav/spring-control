package com.example.projectboard.Service;

import com.example.projectboard.Model.User;
import com.example.projectboard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void deleteUserById(Long id) {
        User deleteUser = findUserById(id);
        userRepository.delete(deleteUser);
    }
}
