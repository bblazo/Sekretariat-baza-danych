package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KlienciDAOTest extends Object {

    private KlienciDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@WiolaASUS:1521:xe");
        dataSource.setUsername("VIOLSON3");
        dataSource.setPassword("VIOLSON3");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new KlienciDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testList() {
        List<Klienci> listKlienci = dao.list();
        System.out.println(listKlienci);
        assertFalse(listKlienci.isEmpty());
    }

    @Test
    void testSave() {
        Klienci klienci = new Klienci(); //dopisać w argumencie głupoty
        dao.save(klienci);
    }

    @Test
    void testGet() {
        int NR_KLIENTA=6;
        Klienci klienci = dao.get(NR_KLIENTA);
        assertNotNull(klienci);
    }

    @Test
    void testUpdate() {
        Klienci klienci = new Klienci();
//        tutaj dopisać głupoty
        dao.update(klienci);
    }

    @Test
    void testDelete() {
        int Nr_klienta = 6;
        dao.delete(Nr_klienta);
    }
}