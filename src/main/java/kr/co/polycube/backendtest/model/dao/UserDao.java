package kr.co.polycube.backendtest.model.dao;

import kr.co.polycube.backendtest.model.dto.User;
import org.springframework.stereotype.Repository;

public interface UserDao {

    User createUser(User user);
    User findById(long id);
    User updateUser(User user, long id);
}
