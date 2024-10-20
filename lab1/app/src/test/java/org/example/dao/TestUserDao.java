package org.example.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TestUserDao {
    

    @Test void testGetAll() {
        UserDao userDao = new UserDao();
        userDao.getAll();
    }
}
