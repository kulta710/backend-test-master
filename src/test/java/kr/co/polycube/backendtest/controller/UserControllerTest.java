package kr.co.polycube.backendtest.controller;

import jakarta.transaction.Transactional;
import kr.co.polycube.backendtest.model.dao.UserDao;
import kr.co.polycube.backendtest.model.dto.User;
import kr.co.polycube.backendtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestRestTemplate restTemplate;

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

        result1.setName("updated-user-name");

        userService.updateUser(result1, id);

        User finalResult = userService.findById(id);

        assertEquals("updated-user-name", finalResult.getName());
    }

    @Test
    void getAPI() {

        ResponseEntity<String> response = restTemplate.getForEntity("/users/1?name=test!!", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}