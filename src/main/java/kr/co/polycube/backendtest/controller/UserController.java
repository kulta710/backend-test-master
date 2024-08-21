package kr.co.polycube.backendtest.controller;

import kr.co.polycube.backendtest.model.dto.User;
import kr.co.polycube.backendtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public Map<String, Long> createUser(@RequestBody User user) {

        User resultUser = userService.createUser(user);

        Map<String, Long> result = new HashMap<String, Long>();
        result.put("id", resultUser.getId());

        return result;
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable long id) {

        return userService.findById(id);
    }

    @PatchMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id) {

        return userService.updateUser(user, id);
    }
}