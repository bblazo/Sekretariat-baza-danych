package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.sql.Date;
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
        List<Wynagrodzenia> listWynagrodzenia = dao.listWynagrodzenia();
        System.out.println(listWynagrodzenia);
        assertFalse(listWynagrodzenia.isEmpty());
    }

    @Test
    void testSave() {
        Wynagrodzenia wynagrodzenia = new Wynagrodzenia(16, new Date(2023, 11, 6), 2500, 2000, 3);
        dao.saveWynagrodzenia(wynagrodzenia);
    }

    @Test
    void testGet() {
        int NR_WYNAGRODZENIA = 16;
        Wynagrodzenia wynagrodzenia = dao.getWynagrodzenia(NR_WYNAGRODZENIA);
        assertNotNull(wynagrodzenia);
    }

    @Test
    void testUpdate() {
        Wynagrodzenia wynagrodzenia = new Wynagrodzenia();
        wynagrodzenia.setNr_wynagrodzenia(16);
        wynagrodzenia.setData(new Date(2023, 12,01));
        wynagrodzenia.setKwota_brutto(4000);
        wynagrodzenia.setKwota_netto(3800);
        wynagrodzenia.setNr_pracownika(4);
        dao.updateWynagrodzenia(wynagrodzenia);
    }

    @Test
    void testDelete() {
        int Nr_wynagrodzenia = 16;
        dao.deleteWynagrodzenia(Nr_wynagrodzenia);
    }
}