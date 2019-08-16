package com.codurance.countries.service;

import com.codurance.countries.domain.MyUser;
import com.codurance.countries.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyUser validate_user(MyUser user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public MyUser create_user(MyUser user) {
        return userRepository.save(user);
    }
}
