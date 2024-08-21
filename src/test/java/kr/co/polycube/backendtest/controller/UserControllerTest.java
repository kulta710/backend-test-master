package kr.co.polycube.backendtest.controller;

import jakarta.transaction.Transactional;
import kr.co.polycube.backendtest.model.dao.UserDao;
import kr.co.polycube.backendtest.model.dto.User;
import kr.co.polycube.backendtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    void createUser() {
        User user = new User();
        user.setName("test-user");

        User result1 = userService.createUser(user);

        long id = result1.getId();

        User result2 = userService.findById(id);

        assertEquals(result1, result2);
    }

    @Test
    void findById() {
        User user = new User();
        user.setName("test-user");

        User result1 = userService.createUser(user);

        long id = result1.getId();

        User result2 = userService.findById(id);

        assertEquals(result1, result2);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setName("update-test-user");

        User result1 = userService.createUser(user);

        long id = result1.getId();

        user.setName("updated-user-name");

        User result2 = userService.updateUser(user, id);

        User finalResult = userService.findById(id);

        assertEquals("updated-user-name", finalResult.getName());
    }
}