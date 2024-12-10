package com.lab2web;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RoleDao <Long, Role> {

    private static final Session session;

    static {
        session
                = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(com.lab2web.Role.class)
                .buildSessionFactory()
                .openSession();
    }

    public Role getById(Long id) {
        Transaction transaction = session.beginTransaction();
        Role role = (Role) session.get(com.lab2web.Role.class, id);
        transaction.commit();
        return role;
    }

    public List<Role> getAll() {
        Transaction transaction = session.beginTransaction();
        List<Role> roles = session.createQuery("from Role", (Class<Role>) com.lab2web.Role.class).getResultList();
        transaction.commit();
        return roles;
    }

    public List<Role> getAll(RoleFilter roleFilter) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereHQL = new ArrayList<>();
        if(roleFilter.name() != null) {
            parameters.add(roleFilter.name());
            whereHQL.add("name like '" + roleFilter.name() + "'");
        }
        parameters.add(roleFilter.limit());
        parameters.add(roleFilter.offset());
        var WHQL = whereHQL.stream().collect(Collectors.joining(
                " and "
        ));
        String HQL = "from Role where " + WHQL;

        Transaction transaction = session.beginTransaction();

        List<Role> roles  = session.createQuery(HQL, (Class<Role>) com.lab2web.Role.class).setFirstResult(roleFilter.offset()).setMaxResults(roleFilter.limit()).getResultList();
        transaction.commit();

        return roles;
    }

    public void save(Role role) {
        try {

            Transaction transaction = session.beginTransaction();

            session.persist(role);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Long id, Role updatedRole) {
        try {

            Transaction transaction = session.beginTransaction();

            session.merge(updatedRole);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try {

            Transaction transaction = session.beginTransaction();
            Role role = (Role) session.find(com.lab2web.Role.class, id);
            session.remove(role);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

