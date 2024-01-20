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
        Uslugi uslugi = new Uslugi(); //dopisać w argumencie głupoty
        dao.save(uslugi);
    }

    @Test
    void testGet() {
        int NR_USLUGI=6;
        Uslugi uslugi = dao.get(NR_USLUGI);
        assertNotNull(uslugi);
    }

    @Test
    void testUpdate() {
        Uslugi uslugi = new Uslugi();
//        tutaj dopisać głupoty
        dao.update(uslugi);
    }

    @Test
    void testDelete() {
        int Nr_uslugi = 6;
        dao.delete(Nr_uslugi);
    }
}