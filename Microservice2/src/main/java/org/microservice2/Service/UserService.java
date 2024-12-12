package org.microservice2.Service;

import org.microservice2.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User fetchUserFromMicroservice1(Long userId) {
        return restTemplate.getForObject("http://localhost:8081/users/" + userId, User.class);
    }

    public String sendUserToMicroservice3(User user) {
        return restTemplate.postForObject("http://localhost:8082/store-users", user, String.class);
    }
}
