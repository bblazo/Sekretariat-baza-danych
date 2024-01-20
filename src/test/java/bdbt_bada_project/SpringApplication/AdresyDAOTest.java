package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresyDAOTest extends Object {
    private AdresyDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@WiolaAsus:1521:xe");
        dataSource.setUsername("VIOLSON3");
        dataSource.setPassword("VIOLSON3");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresyDAO(new JdbcTemplate(dataSource));
    }


    @Test
    void testList() {
        /*
        Import java.util
         */
        List<Adresy> listAdresy = dao.list();
        System.out.println(listAdresy);
        assertFalse(listAdresy.isEmpty());
    }

    @Test
    void testSave() {
        Adresy adresy = new Adresy(); //dopisać w argumencie głupoty
        dao.save(adresy);
    }

    @Test
    void testGet() {
        int NR_ADRESU=6;
        Adresy adresy = dao.get(NR_ADRESU);
        assertNotNull(adresy);
    }

    @Test
    void testUpdate() {
        Adresy adresy = new Adresy();
//        tutaj dopisać głupoty
        dao.update(adresy);
    }

    @Test
    void testDelete() {
        int Nr_adresu = 6;
        dao.delete(Nr_adresu);
    }
}