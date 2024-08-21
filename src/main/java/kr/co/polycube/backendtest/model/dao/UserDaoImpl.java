package kr.co.polycube.backendtest.model.dao;

import jakarta.persistence.EntityManager;
import kr.co.polycube.backendtest.model.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {

        this.em = em;
    }

    @Override
    public User createUser(User user) {

        em.persist(user);

        return user;
    }

    @Override
    public User findById(long id) {

        return em.find(User.class, id);
    }

    @Override
    public User updateUser(User user, long id) {

        User userA = em.find(User.class, id);

        userA.setName(user.getName());

        return userA;
    }
}