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
public class WynagrodzeniaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WynagrodzeniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Wynagrodzenia> listWynagrodzenia(){
        String sql = "SELECT * FROM WYNAGRODZENIA";
        List<Wynagrodzenia> listWynagrodzenia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return listWynagrodzenia;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void saveWynagrodzenia(Wynagrodzenia wynagrodzenia) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("WYNAGRODZENIA").usingColumns("NR_WYNAGRODZENIA", "DATA", "KWOTA_BRUTTO", "KWOTA_NETTO", "NR_PRACOWNIKA");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Wynagrodzenia getWynagrodzenia(int NR_WYNAGRODZENIA) {
        String sql = "SELECT * FROM Wynagrodzenia WHERE NR_WYNAGRODZENIA = ?";
        Object[] args = {NR_WYNAGRODZENIA};
        Wynagrodzenia wynagrodzenia = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return wynagrodzenia;
    }
    /* Update – aktualizacja danych */
    public void updateWynagrodzenia(Wynagrodzenia wynagrodzenia) {
        String sql = "UPDATE WYNAGRODZENIA SET data=:data, kwota_brutto=:kwota_brutto, kwota_netto=:kwota_netto WHERE Nr_wynagrodzenia=:Nr_wynagrodzenia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deleteWynagrodzenia(int Nr_wynagrodzenia) {
        String sql = "DELETE FROM WYNAGRODZENIA WHERE Nr_wynagrodzenia = ?";
        jdbcTemplate.update(sql, Nr_wynagrodzenia);
    }
}
