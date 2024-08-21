package kr.co.polycube.backendtest.service;

import kr.co.polycube.backendtest.model.dto.User;

public interface UserService {

    User createUser(User user);
    User findById(long id);
    User updateUser(User user, long id);
}