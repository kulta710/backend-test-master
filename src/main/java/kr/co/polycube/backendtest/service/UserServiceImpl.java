package kr.co.polycube.backendtest.service;

import jakarta.transaction.Transactional;
import kr.co.polycube.backendtest.model.dao.UserDao;
import kr.co.polycube.backendtest.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {

        return userDao.createUser(user);
    }

    @Override
    public User findById(long id) {

        return userDao.findById(id);
    }

    @Override
    public User updateUser(User user, long id) {

        return userDao.updateUser(user, id);
    }
}