package bdbt_bada_project.SpringApplication;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UslugiDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UslugiDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Uslugi> list(){
        String sql = "SELECT * FROM USLUGI";
        List<Uslugi> listUslugi = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Uslugi.class));
        return listUslugi;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Uslugi sale) {
    }
    /* Read – odczytywanie danych z bazy */
    public Uslugi get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Uslugi sale) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}