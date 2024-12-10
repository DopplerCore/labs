import by.caster.DatabaseManager;
import dao.RoleDao;
import entity.Role;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRoleDao {

    @org.junit.jupiter.api.Test
    public void test() {
        try {
            DatabaseManager.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RoleDao testdao = new RoleDao();
        testdao.save(new Role("Javascript", 1L));
        testdao.save(new Role("Maksim", 2L));

        testdao.save(new Role("Dimon", 3L));
        testdao.update(2L,new Role("Maks", 2L));
        testdao.delete(1L);
        assertTrue(testdao.getById(3L).equals(new Role("Dimon", 3L)));
        assertTrue(testdao.getAll().get(0).equals(new Role("Maks", 2L)));

    }
}
