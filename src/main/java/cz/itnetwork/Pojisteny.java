package cz.itnetwork;
// jednotlivé vlastnosti pojištěného.
public class Pojisteny {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    //  konstruktor třídy Pojisteny
    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }


    // metoda toString() pro výpis informací o pojištěném.
    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", věk: " + vek + ", telefon: " + telefon;
    }



    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

}

