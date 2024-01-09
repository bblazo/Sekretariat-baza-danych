package bdbt_bada_project.SpringApplication;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PracownicyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    /* Import java.util.List */
    public List<Pracownicy> list(){
        String sql = "SELECT * FROM Pracownicy";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("nr_pracownika","imie","drugie_Imie","nazwisko","plec","nr_telefonu","data_urodzenia","adres_email","PESEL","data_zatrudnienia","data_zwolnienia","upomnienia","pochwaly", "nr_sekretariatu", "nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownicy get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Pracownicy pracownicy) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
