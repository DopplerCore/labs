package org.example.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Assertions;

import org.example.models.User;
import org.junit.jupiter.api.Test;

public class TestUserDao {

    @Test void test() {
        UserDao userDao = new UserDao();
        User user1 = new User(101,"Dimon", "male", "dom Kolotushkina", "103");
        User user2 = new User(202,"Fedor", "male", "dom", "+375259510698");
        userDao.save(user1);
        userDao.save(user2);
        Assertions.assertTrue(user1.equals(userDao.getById(101)));
        Assertions.assertTrue(user2.equals(userDao.getById(202)));

        Assertions.assertTrue(userDao.getAll().get(1).equals(user2));
        user1.setName("Mashina");
        userDao.update(101, user1);
        Assertions.assertTrue(user1.equals(userDao.getById(101)));
        userDao.delete(101);
        Assertions.assertTrue(userDao.getById(101).getName() == null);
        System.out.println(userDao.getAll().stream().toString());
        userDao.delete(202);
    }
}
