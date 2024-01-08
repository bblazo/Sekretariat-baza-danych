package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class UslugiDAOTest extends Object {

    private UslugiDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@WiolaAsus:1521:xe");
        dataSource.setUsername("VIOLSON3");
        dataSource.setPassword("VIOLSON3");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new UslugiDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testList() {
        /*
        Import java.util
                */
        List<Uslugi> listUslugi = dao.list();
        System.out.println(listUslugi);
        assertFalse(listUslugi.isEmpty());
    }

    @Test
    void testSave() {
        fail("Not yet implemented");
    }

    @Test
    void testGet() {
        fail("Not yet implemented");
    }

    @Test
    void testUpdate() {
        fail("Not yet implemented");
    }

    @Test
    void testDelete() {
        fail("Not yet implemented");
    }
}