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
public class PracownicyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    /* Import java.util.List */
    public List<Pracownicy> listPracownicy(){
        String sql = "SELECT * FROM Pracownicy";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void savePracownicy(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PRACOWNICY").usingColumns("NR_PRACOWNIKA","IMIE","DRUGIE_IMIE","NAZWISKO","PLEC","NR_TELEFONU","DATA_URODZENIA","ADRES_EMAIL","PESEL","DATA_ZATRUDNIENIA","DATA_ZWOLNIENIA","UPOMNIENIA","POCHWALY", "NR_SEKRETARIATU", "NR_ADRESU");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownicy getPracownicy(int NR_PRACOWNIKA) {
        String sql = "SELECT * FROM Pracownicy WHERE NR_PRACOWNIKA = ?";
        Object[] args = {NR_PRACOWNIKA};
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    /* Update – aktualizacja danych */
    public void updatePracownicy(Pracownicy pracownicy) {
        String sql = "UPDATE PRACOWNICY SET imie=:imie, drugie_Imie=:drugie_Imie, nazwisko=:nazwisko, plec=:plec, nr_telefonu=:nr_telefonu, data_urodzenia=:data_urodzenia, adres_email=:adres_email, PESEL=:PESEL, data_zatrudnienia=:data_zatrudnienia, data_zwolnienia=:data_zwolnienia, upomnienia=:upomnienia, pochwaly=:pochwaly WHERE Nr_pracownika=:Nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deletePracownicy(int Nr_pracownika) {
        String sql = "DELETE FROM PRACOWNICY WHERE Nr_pracownika = ?";
        jdbcTemplate.update(sql, Nr_pracownika);
    }
}
