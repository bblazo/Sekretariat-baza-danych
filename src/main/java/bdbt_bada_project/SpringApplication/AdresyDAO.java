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
public class AdresyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Adresy> list(){
        String sql = "SELECT * FROM ADRESY";
        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adresy adresy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ADRESY").usingColumns("NR_ADRESU","MIASTO","ULICA","NR_LOKALU","NR_POCZTY");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Adresy get(int NR_ADRESU) {
        String sql = "SELECT * FROM Adresy WHERE NR_ADRESU = ?";
        Object[] args = {NR_ADRESU};
        Adresy adresy = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Adresy.class));
        return adresy;
    }
    /* Update – aktualizacja danych */
    public void update(Adresy adresy) {
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica WHERE Nr_adresu=:Nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_adresu) {
        String sql = "DELETE FROM ADRESY WHERE Nr_adresu = ?";
        jdbcTemplate.update(sql, Nr_adresu);
    }


}
