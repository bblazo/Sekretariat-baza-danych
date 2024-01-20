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
        Klienci klienci = new Klienci(8, 347522398, "kurczak@o2.pl", new Date(2023,12,8), 1, 5); //dopisać w argumencie głupoty
        dao.save(klienci);
    }

    @Test
    void testGet() {
        int NR_KLIENTA=8;
        Klienci klienci = dao.get(NR_KLIENTA);
        assertNotNull(klienci);
    }

    @Test
    void testUpdate() {
        Klienci klienci = new Klienci();
        klienci.setNr_klienta(8);
        klienci.setNr_telefonu(786934702);
        klienci.setAdres_email("kurczątko@o2.pl");
        klienci.setData_przybycia(new Date(2023, 04,9));
        klienci.setNr_sekretariatu(1);
        klienci.setNr_adresu(3);
        dao.update(klienci);
    }

    @Test
    void testDelete() {
        int Nr_klienta = 8;
        dao.delete(Nr_klienta);
    }
}