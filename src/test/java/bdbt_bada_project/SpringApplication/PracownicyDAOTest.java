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
        List<Pracownicy> listPracownicy = dao.list();
        System.out.println(listPracownicy);
        assertFalse(listPracownicy.isEmpty());
    }

    @Test
    void save() {
        Pracownicy pracownicy = new Pracownicy(4, "Grzehu", "null", "Papież", "M", 321321321, new Date(1, 2, 3), "jo@o2.pl", "03445908897", new Date(11, 2, 3), new Date(2,8,3), 6, 4, 1, 1);
        dao.save(pracownicy);
    }
    void get() {
        fail("Not yet implemented");
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
        fail("Not yet implemented");
    }
}