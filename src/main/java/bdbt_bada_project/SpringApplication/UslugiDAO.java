package bdbt_bada_project.SpringApplication;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
    public void save(Uslugi uslugi) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("USLUGI").usingColumns("NR_USLUGI","NR_STANOWISKA","RODZAJ_USLUGI","NR_SEKRETARIATU");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uslugi);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Uslugi get(int NR_ADRESU) {
        String sql = "SELECT * FROM Uslugi WHERE NR_USLUGI = ?";
        Object[] args = {NR_ADRESU};
        Uslugi uslugi = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Uslugi.class));
        return uslugi;
    }
    /* Update – aktualizacja danych */
    public void update(Uslugi uslugi) {
        String sql = "UPDATE USLUGI SET nr_stanowiska=:nr_stanowiska, rodzaj_uslugi=:rodzaj_uslugi WHERE Nr_uslugi=:Nr_uslugi";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uslugi);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_uslugi) {
        String sql = "DELETE FROM USLUGI WHERE Nr_uslugi = ?";
        jdbcTemplate.update(sql, Nr_uslugi);
    }
}