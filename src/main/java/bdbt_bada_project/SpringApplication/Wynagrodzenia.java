package bdbt_bada_project.SpringApplication;

import java.sql.Date;

public class Wynagrodzenia {
    private int nr_wynagrodzenia;
    private Date data;
    private int kwota_brutto;
    private int kwota_netto;
    private int nr_pracownika;

    public Wynagrodzenia(){

    }

    public Wynagrodzenia(int nr_wynagrodzenia, Date data, int kwota_brutto, int kwota_netto, int nr_pracownika) {
        super();
        this.nr_wynagrodzenia = nr_wynagrodzenia;
        this.data = data;
        this.kwota_brutto = kwota_brutto;
        this.kwota_netto = kwota_netto;
        this.nr_pracownika = nr_pracownika;
    }

    public int getNr_wynagrodzenia() {
        return nr_wynagrodzenia;
    }

    public void setNr_wynagrodzenia(int nr_wynagrodzenia) {
        this.nr_wynagrodzenia = nr_wynagrodzenia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getKwota_brutto() {
        return kwota_brutto;
    }

    public void setKwota_brutto(int kwota_brutto) {
        this.kwota_brutto = kwota_brutto;
    }

    public int getKwota_netto() {
        return kwota_netto;
    }

    public void setKwota_netto(int kwota_netto) {
        this.kwota_netto = kwota_netto;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    @Override
    public String toString() {
        return "Wynagrodzenia{" +
                "nr_wynagrodzenia=" + nr_wynagrodzenia +
                ", data=" + data +
                ", kwota_brutto=" + kwota_brutto +
                ", kwota_netto=" + kwota_netto +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}
