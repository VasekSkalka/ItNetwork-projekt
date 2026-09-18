package cz.itnetwork;

import java.util.Scanner;

public class Aplikace {
    //   Scanner pro čtení vstupu od uživatele
    private Scanner scanner = new Scanner(System.in);
    //   Evidence pro správu pojištěných
    private Evidence evidence = new Evidence();

    public void pridejPojisteneho() {
        // načtení údajů o od uživatele
        String jmeno = nactiText("Zadejte jméno pojištěného: ");
        // Původní řešení, později nahrazena metodou nactiText().
        //while (jmeno.isBlank()) {
        //    System.out.println("Jméno nesmí být prázdné.");
        //    System.out.println("Zadejte jméno pojištěného: ");
        //    jmeno = sc.nextLine();
        //}

        String prijmeni = nactiText("Zadejte příjmení pojištěného: ");

        int vek = Integer.parseInt(nactiText("Zadejte věk pojištěného: "));

        String telefon = nactiText("Zadejte telefonní číslo pojištěného: ");

        // vytvoření pojištěného a přidání do evidence
        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
        evidence.pridejPojisteneho(pojisteny);
    }

    // výpis všech pojištěných
    public void vypisPojistene() {
        for (Pojisteny uzivatel : evidence.getPojisteni()) {
            System.out.println(uzivatel);
        }
    }

    // vyhledávání podle jména a příjmení
    public void vyhledejPojisteneho() {

        System.out.println("Zadejte jméno pojištěného: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení pojištěného: ");
        String prijmeni = scanner.nextLine();

        Pojisteny nalezeny = evidence.hledat(jmeno, prijmeni);

        if (nalezeny != null) {
            System.out.println(nalezeny);
        } else {
            System.out.println("Pojištěný nebyl nalezen.");
        }

    }

    // metoda pro spuštění aplikace
    public void spustit() {
        String volba = "";
        // cyklus pro zobrazení menu a zpracování volby uživatele
        while (!volba.equals("4")) {
            System.out.println();
            System.out.println("------------------------------");
            System.out.println("Evidence pojištěných");
            System.out.println("------------------------------");
            System.out.println("1 - Přidat pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");
            System.out.println("------------------------------");
            System.out.print("Vyberte možnost: ");

            volba = scanner.nextLine();
            // zpracování volby uživatele
            // Dokumentace:
            // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
            switch (volba) {
                case "1":
                    pridejPojisteneho();
                    break;

                case "2":
                    vypisPojistene();
                    break;

                case "3":
                    vyhledejPojisteneho();
                    break;

                case "4":
                    System.out.println("Program byl ukončen.");
                    break;

                default:
                    System.out.println("Neplatná volba.");
            }
        }


    }

    // načtení textu od uživatele s kontrolou, zda není prázdný
    private String nactiText(String vyzva) {
        System.out.println(vyzva);
        String text = scanner.nextLine();

        while (text.isBlank()) {
            System.out.println("Hodnota nesmí být prázdná.");
            System.out.println(vyzva);
            text = scanner.nextLine();
        }
        //  Vrátí zadaný neprázdný text
        return text;
    }

}