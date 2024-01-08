package bdbt_bada_project.SpringApplication;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class KlienciDAO {

    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    /* Import java.util.List */
    public List<Klienci> list(){
        String sql = "SELECT * FROM Klienci";

        List<Klienci> listKlienci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
        return listKlienci;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klienci klienci) {
    }
    /* Read – odczytywanie danych z bazy */
    public Klienci get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Klienci klienci) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
