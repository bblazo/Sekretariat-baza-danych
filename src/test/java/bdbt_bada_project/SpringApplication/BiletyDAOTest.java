package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiletyDAOTest extends Object {

    private BiletyDAO dao;
    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@WiolaASUS:1521:xe");
        dataSource.setUsername("VIOLSON3");
        dataSource.setPassword("VIOLSON3");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new BiletyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void listBilety() {
        List<Bilety> listBilety = dao.listBilety();
        System.out.println(listBilety);
        assertFalse(listBilety.isEmpty());
    }

    @Test
    void listBiletyForClient() {
        int id = 8;
        List<Bilety> actualListBilety = dao.listBiletyForClient(id); //actual
        System.out.println(actualListBilety);
    }

    @Test
    void saveBilety() {
        Bilety bilety = new Bilety(7, 9, new Date(2024,01,24), 2); //dopisać w argumencie głupoty
        dao.saveBilety(bilety);
    }

    @Test
    void getBilety() {
        int NR_BILETU=2;
        Bilety bilety = dao.getBilety(NR_BILETU);
        assertNotNull(bilety);
    }

    @Test
    void deleteBilety() {
        int Nr_biletu = 2;
        dao.deleteBilety(Nr_biletu);
    }
}