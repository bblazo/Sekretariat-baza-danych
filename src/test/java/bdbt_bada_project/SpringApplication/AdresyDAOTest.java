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
        List<Adresy> listAdresy = dao.listAdresy();
        System.out.println(listAdresy);
        assertFalse(listAdresy.isEmpty());
    }

    @Test
    void testSave() {
        Adresy adresy = new Adresy(12, "Szulborze Wielkie", "Szarych Szeregów", 1, 3);
        dao.saveAdresy(adresy);
    }

    @Test
    void testGet() {
        int NR_ADRESU=12;
        Adresy adresy = dao.getAdresy(NR_ADRESU);
        assertNotNull(adresy);
    }

    @Test
    void testUpdate() {
        Adresy adresy = new Adresy();
        adresy.setNr_adresu(12);
        adresy.setMiasto("Warszawa");
        adresy.setUlica("Waryńskiego");
        adresy.setNr_lokalu(12);
        adresy.setNr_poczty(2);
        dao.updateAdresy(adresy);
    }

    @Test
    void testDelete() {
        int Nr_adresu = 12;
        dao.deleteAdresy(Nr_adresu);
    }
}