package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PracownicyDAOTest extends Object {

    private PracownicyDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@WiolaASUS:1521:xe");
        dataSource.setUsername("VIOLSON3");
        dataSource.setPassword("VIOLSON3");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownicyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Pracownicy> listPracownicy = dao.listPracownicy();
        System.out.println(listPracownicy);
        assertFalse(listPracownicy.isEmpty());
    }

    @Test
    void save() {
        Pracownicy pracownicy = new Pracownicy(5, "Grzehu", "null", "Papież", "M", 321321321, new Date(2001, 2, 3), "jo@o2.pl", "03445908897", new Date(2011, 2, 3), new Date(2002,8,3), "6", "4", 1, 1);
        dao.savePracownicy(pracownicy);
    }
    @Test
    void get() {
        int NR_PRACOWNIKA=6;
        Pracownicy pracownicy = dao.getPracownicy(NR_PRACOWNIKA);
        assertNotNull(pracownicy);
    }

    @Test
    void update() {
        Pracownicy pracownicy = new Pracownicy();
        pracownicy.setNr_pracownika(5);
        pracownicy.setImie("Grzechu");
        pracownicy.setDrugie_Imie("MJ");
        pracownicy.setNazwisko("Szef");
        pracownicy.setPlec("M");
        pracownicy.setNr_telefonu(253758425);
        pracownicy.setData_urodzenia(new Date(2000,10,05));
        pracownicy.setAdres_email("papaj@wp.pl");
        pracownicy.setPESEL("00352648567");
        pracownicy.setData_zatrudnienia(new Date(2011, 04, 03));
        pracownicy.setData_zwolnienia(new Date(2012,04,01));
        pracownicy.setUpomnienia("1");
        pracownicy.setPochwaly("3");
        pracownicy.setNr_sekretariatu(1);
        pracownicy.setNr_adresu(2);
        dao.updatePracownicy(pracownicy);
    }

    @Test
    void delete() {
        int Nr_pracownika = 6;
        dao.deletePracownicy(Nr_pracownika);
    }
}