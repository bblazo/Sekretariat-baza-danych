package bdbt_bada_project.SpringApplication;
import java.sql.Date;

public class Klienci {
    private int Nr_klienta;
    private int Nr_telefonu;
    private String Adres_email;
    private Date Data_przybycia;
    private int Nr_sekretariatu;
    private int Nr_adresu;

    public Klienci() {

    }

    public Klienci(int nr_klienta, int nr_telefonu, String adres_email, Date data_przybycia, int nr_sekretariatu, int nr_adresu) {
        super();
        this.Nr_klienta = nr_klienta;
        this.Nr_telefonu = nr_telefonu;
        this.Adres_email = adres_email;
        this.Data_przybycia = data_przybycia;
        this.Nr_sekretariatu = nr_sekretariatu;
        this.Nr_adresu = nr_adresu;
    }

    public int getNr_klienta() {
        return Nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        Nr_klienta = nr_klienta;
    }

    public int getNr_telefonu() {
        return Nr_telefonu;
    }

    public void setNr_telefonu(int nr_telefonu) {
        Nr_telefonu = nr_telefonu;
    }

    public String getAdres_email() {
        return Adres_email;
    }

    public void setAdres_email(String adres_email) {
        Adres_email = adres_email;
    }

    public Date getData_przybycia() {
        return Data_przybycia;
    }

    public void setData_przybycia(Date data_przybycia) {
        Data_przybycia = data_przybycia;
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
        return "Klienci{" +
                "Nr_klienta=" + Nr_klienta +
                ", Nr_telefonu=" + Nr_telefonu +
                ", Adres_email='" + Adres_email + '\'' +
                ", Data_przybycia=" + Data_przybycia +
                ", Nr_sekretariatu=" + Nr_sekretariatu +
                ", Nr_adresu=" + Nr_adresu +
                '}';
    }
}

