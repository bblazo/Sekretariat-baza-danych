package bdbt_bada_project.SpringApplication;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "SELECT * FROM SALES";
        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adresy sale) {
    }
    /* Read – odczytywanie danych z bazy */
    public Adresy get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Adresy sale) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }


}
