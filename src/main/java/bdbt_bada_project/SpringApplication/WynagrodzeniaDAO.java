package bdbt_bada_project.SpringApplication;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class WynagrodzeniaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WynagrodzeniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Wynagrodzenia> list(){
        String sql = "SELECT * FROM WYNAGRODZENIA";
        List<Wynagrodzenia> listWynagrodzenia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return listWynagrodzenia;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Wynagrodzenia sale) {
    }
    /* Read – odczytywanie danych z bazy */
    public Wynagrodzenia get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Wynagrodzenia sale) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
