package by.caster;

import dao.RoleDao;
import dto.RoleFilter;
import entity.Role;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        RoleDao roleDao = new RoleDao();
        System.out.println(roleDao.getAll());
        System.out.println(roleDao.getById(2L));
        roleDao.update(2L,new Role("Manager", 2L));
        roleDao.delete(3L);
        System.out.println(roleDao.getAll());
        RoleFilter roleFilter = new RoleFilter("ClubName",0,2);
        System.out.println(roleDao.getAll(roleFilter));
    }
}