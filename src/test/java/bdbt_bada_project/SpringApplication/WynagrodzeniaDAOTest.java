package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WynagrodzeniaDAOTest extends Object {
    private WynagrodzeniaDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@WiolaAsus:1521:xe");
        dataSource.setUsername("VIOLSON3");
        dataSource.setPassword("VIOLSON3");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new WynagrodzeniaDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testList() {
        /*
        Import java.util
         */
        List<Wynagrodzenia> listWynagrodzenia = dao.list();
        System.out.println(listWynagrodzenia);
        assertFalse(listWynagrodzenia.isEmpty());
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