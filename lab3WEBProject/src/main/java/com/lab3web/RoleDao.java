package com.lab3web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoleDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Role getById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Role role = (Role) session.get(Role.class, id);
        transaction.commit();
        return role;
    }

    public List<Role> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Role> roles = session.createQuery("from Role", Role.class).getResultList();
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
        var WHQL = whereHQL.stream().collect(Collectors.joining(
                " and "
        ));
        String HQL = "from Role where " + WHQL;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Role> roles  = session.createQuery(HQL, Role.class).setFirstResult(roleFilter.offset()).setMaxResults(roleFilter.limit()).getResultList();
        transaction.commit();
        return roles;
    }

    public void save(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(role);
        transaction.commit();
    }

    public void update(Long id, Role updatedRole) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(updatedRole);
        transaction.commit();
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Role role = session.find(Role.class, id);
        session.remove(role);
        transaction.commit();
    }
}

