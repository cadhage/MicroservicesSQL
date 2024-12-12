package org.microservice3.Service;

import org.microservice3.Model.User;
import org.microservice3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void storeUser(User user) {
        userRepository.save(user);
    }
}
