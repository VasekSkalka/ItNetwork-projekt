package cz.itnetwork;

import java.util.ArrayList;
import java.util.List;

    //seznam pojištěbých
public class Evidence {
    private List<Pojisteny> pojisteni = new ArrayList<>();

    // přidání pojištěného do seznamu
    public void pridejPojisteneho(Pojisteny pojisteny) {
        pojisteni.add(pojisteny);
    }

    // získání seznamu pojištěných s getrem
    public List<Pojisteny> getPojisteni() {
        return pojisteni;
    }


    // vyhledání pojištěného podle jména a příjmení
    public Pojisteny hledat(String jmeno, String prijmeni) {
        for (Pojisteny obcan : pojisteni) {
            if (obcan.getJmeno().equals(jmeno) &&
                    obcan.getPrijmeni().equals(prijmeni)) {
                return obcan;
            }
        }

     //nikdo nebyl nalezen
        return null;
    }
}