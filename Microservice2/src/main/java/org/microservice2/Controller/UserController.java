package org.microservice2.Controller;

import org.microservice2.Model.User;
import org.microservice2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process-users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/fetch-and-process")
    public String fetchAndProcessUser(@RequestParam Long userId) {
        User user = (User) userService.fetchUserFromMicroservice1(userId);
        return userService.sendUserToMicroservice3(user);
    }
}
