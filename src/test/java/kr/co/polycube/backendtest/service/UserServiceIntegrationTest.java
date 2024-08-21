package kr.co.polycube.backendtest.service;

import jakarta.transaction.Transactional;
import kr.co.polycube.backendtest.model.dao.UserDao;
import kr.co.polycube.backendtest.model.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;
}
