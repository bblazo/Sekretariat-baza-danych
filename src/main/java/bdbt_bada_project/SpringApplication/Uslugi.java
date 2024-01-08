package bdbt_bada_project.SpringApplication;

public class Uslugi {
    private int Nr_uslugi;
    private int Nr_stanowiska;
    private String Rodzaj_uslugi;
    private int Nr_sekretariatu;

    public Uslugi(){

    }

    public Uslugi(int nr_uslugi, int nr_stanowiska, String rodzaj_uslugi, int nr_sekretariatu) {
        super();
        this.Nr_uslugi = nr_uslugi;
        this.Nr_stanowiska = nr_stanowiska;
        this.Rodzaj_uslugi = rodzaj_uslugi;
        this.Nr_sekretariatu = nr_sekretariatu;
    }

    public int getNr_uslugi() {
        return Nr_uslugi;
    }

    public void setNr_uslugi(int nr_uslugi) {
        Nr_uslugi = nr_uslugi;
    }

    public int getNr_stanowiska() {
        return Nr_stanowiska;
    }

    public void setNr_stanowiska(int nr_stanowiska) {
        Nr_stanowiska = nr_stanowiska;
    }

    public String getRodzaj_uslugi() {
        return Rodzaj_uslugi;
    }

    public void setRodzaj_uslugi(String rodzaj_uslugi) {
        Rodzaj_uslugi = rodzaj_uslugi;
    }

    public int getNr_sekretariatu() {
        return Nr_sekretariatu;
    }

    public void setNr_sekretariatu(int nr_sekretariatu) {
        Nr_sekretariatu = nr_sekretariatu;
    }

    @Override
    public String toString() {
        return "Uslugi{" +
                "Nr_uslugi=" + Nr_uslugi +
                ", Nr_stanowiska=" + Nr_stanowiska +
                ", Rodzaj_uslugi='" + Rodzaj_uslugi + '\'' +
                ", Nr_sekretariatu=" + Nr_sekretariatu +
                '}';
    }
}
