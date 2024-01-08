package bdbt_bada_project.SpringApplication;
import java.sql.Date;

public class Pracownicy {
    private int Nr_pracownika;
    private String Imie;
    private String Drugie_Imie;
    private String Nazwisko;
    private String Plec;
    private int Nr_telefonu;
    private Date Data_urodzenia;
    private String Adres_email;
    private String PESEL;
    private Date Data_zatrudnienia;
    private Date Data_zwolnienia;
    private String Upomnienia;
    private String Pochwaly;
    private int Nr_sekretariatu;
    private int Nr_adresu;

    public Pracownicy(){

    }

    public Pracownicy(int nr_pracownika, String imie, String drugie_Imie, String nazwisko, String plec, int nr_telefonu, Date data_urodzenia, String adres_email, String PESEL, Date data_zatrudnienia, Date data_zwolnienia, String upomnienia, String pochwaly, int nr_sekretariatu, int nr_adresu) {
        super();
        this.Nr_pracownika = nr_pracownika;
        this.Imie = imie;
        this.Drugie_Imie = drugie_Imie;
        this.Nazwisko = nazwisko;
        this.Plec = plec;
        this.Nr_telefonu = nr_telefonu;
        this.Data_urodzenia = data_urodzenia;
        this.Adres_email = adres_email;
        this.PESEL = PESEL;
        this.Data_zatrudnienia = data_zatrudnienia;
        this.Data_zwolnienia = data_zwolnienia;
        this.Upomnienia = upomnienia;
        this.Pochwaly = pochwaly;
        this.Nr_sekretariatu = nr_sekretariatu;
        this.Nr_adresu = nr_adresu;
    }

    public int getNr_pracownika() {
        return Nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        Nr_pracownika = nr_pracownika;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getDrugie_Imie() {
        return Drugie_Imie;
    }

    public void setDrugie_Imie(String drugie_Imie) {
        Drugie_Imie = drugie_Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getPlec() {
        return Plec;
    }

    public void setPlec(String plec) {
        Plec = plec;
    }

    public int getNr_telefonu() {
        return Nr_telefonu;
    }

    public void setNr_telefonu(int nr_telefonu) {
        Nr_telefonu = nr_telefonu;
    }

    public Date getData_urodzenia() {
        return Data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }

    public String getAdres_email() {
        return Adres_email;
    }

    public void setAdres_email(String adres_email) {
        Adres_email = adres_email;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public Date getData_zatrudnienia() {
        return Data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        Data_zatrudnienia = data_zatrudnienia;
    }

    public Date getData_zwolnienia() {
        return Data_zwolnienia;
    }

    public void setData_zwolnienia(Date data_zwolnienia) {
        Data_zwolnienia = data_zwolnienia;
    }

    public String getUpomnienia() {
        return Upomnienia;
    }

    public void setUpomnienia(String upomnienia) {
        Upomnienia = upomnienia;
    }

    public String getPochwaly() {
        return Pochwaly;
    }

    public void setPochwaly(String pochwaly) {
        Pochwaly = pochwaly;
    }

    public int getNr_sekretariatu() {
        return Nr_sekretariatu;
    }

    public void setNr_sekretariatu(int nr_sekretariatu) {
        Nr_sekretariatu = nr_sekretariatu;
    }

    public int getNr_adresu() {
        return Nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        Nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "Nr_pracownika=" + Nr_pracownika +
                ", Imie='" + Imie + '\'' +
                ", Drugie_Imie='" + Drugie_Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", Plec='" + Plec + '\'' +
                ", Nr_telefonu=" + Nr_telefonu +
                ", Data_urodzenia=" + Data_urodzenia +
                ", Adres_email='" + Adres_email + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", Data_zatrudnienia=" + Data_zatrudnienia +
                ", Data_zwolnienia=" + Data_zwolnienia +
                ", Upomnienia=" + Upomnienia +
                ", Pochwaly=" + Pochwaly +
                ", Nr_sekretariatu=" + Nr_sekretariatu +
                ", Nr_adresu=" + Nr_adresu +
                '}';
    }




}

