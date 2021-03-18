package com.elastic.springelastic.service;

import com.elastic.springelastic.model.Users;
import com.elastic.springelastic.repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users users) {

        return userRepository.save(users);
    }


    public void delete(Users book) {
        userRepository.delete(book);
    }


    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }


    public List<Users> findByName(String name) {
        return userRepository.findByName(name);
    }
}
