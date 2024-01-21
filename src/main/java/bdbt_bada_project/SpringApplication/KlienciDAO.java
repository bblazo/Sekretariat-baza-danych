package bdbt_bada_project.SpringApplication;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
    public List<Klienci> listKlienci(){
        String sql = "SELECT * FROM Klienci";

        List<Klienci> listKlienci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
        return listKlienci;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void saveKlienci(Klienci klienci) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KLIENCI").usingColumns("NR_KLIENTA","NR_TELEFONU","ADRES_EMAIL","DATA_PRZYBYCIA", "NR_SEKRETARIATU", "NR_ADRESU");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Klienci getKlienci(int NR_KLIENTA) {
        String sql = "SELECT * FROM Klienci WHERE NR_KLIENTA = ?";
        Object[] args = {NR_KLIENTA};
        Klienci klienci = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Klienci.class));
        return klienci;
    }
    /* Update – aktualizacja danych */
    public void updateKlienci(Klienci klienci) {
        String sql = "UPDATE KLIENCI SET nr_telefonu=:nr_telefonu, adres_email=:adres_email, data_przybycia=:data_przybycia WHERE Nr_klienta=:Nr_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deleteKlienci(int Nr_klienta) {
        String sql = "DELETE FROM KLIENCI WHERE Nr_klienta = ?";
        jdbcTemplate.update(sql, Nr_klienta);
    }

}