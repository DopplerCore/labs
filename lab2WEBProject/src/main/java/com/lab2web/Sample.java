package com.lab2web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;
import java.util.function.Function;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Sample implements Serializable {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        roleDao.save(new Role("Manager",2L));
        roleDao.save(new Role("TrovePlayer",1L));
        roleDao.save(new Role("DungeonMaster",3L));
        System.out.println(roleDao.getAll());
        System.out.println(roleDao.getById(2L));
        roleDao.update(2L,new Role("TrueManager", 2L));
        System.out.println(roleDao.getById(2L));
        roleDao.delete(3L);
        System.out.println(roleDao.getAll());
        RoleFilter roleFilter = new RoleFilter("TrovePlayer",0,2);
        System.out.println(roleDao.getAll(roleFilter));
    }
}
