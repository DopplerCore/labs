package com.lab4web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Sample {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        RoleDao roleDao = (RoleDao) context.getBean("dao");
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
