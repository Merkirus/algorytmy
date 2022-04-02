package lab5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BazaDanych {

    private final static String[] MARKI = {
            "Audi", "BMW", "Kia", "Hyundai",
            "Ford", "Toyota", "Honda", "Subaru",
            "Opel", "Chrysler", "Dodge", "Volkswagen",
            "Peugeot", "Renault", "Citroen", "Ferrari",
            "Porshe", "Fiat", "Rimac", "Łada", "Trabant"
    };

    private final static String[] TYP = {
            "Kabriolet", "Hatchback", "Van", "Sedan",
            "Limuzyna", "Pick-up", "Kombi", "Roadster",
            "SUV", "Jeep"
    };

    private final static String[] KOLOR = {
            "Różowy", "Czerwony", "Zielony", "Pomarańczowy",
            "Czarny", "Biały", "Szary", "Grafitowy", "Niebieski",
            "Srebrny", "Żółty", "Fioletowy", "Beżowy"
    };

    private ArrayList<String> bazaMarek;
    private ArrayList<String> bazaRocznikow;

    private L2KCzS<Auto> lista;
    private boolean isRunning;

    public BazaDanych() {
        this.lista = new L2KCzS<>();
        this.bazaMarek = new ArrayList<>();
        this.bazaRocznikow = new ArrayList<>();
        this.isRunning = true;
    }

    public void run() {
        makeDatabase();
        while (isRunning) {
            helpRun();
        }
    }

    private void helpRun() {
        System.out.println("Proszę wybrać operację: ");
        System.out.println("1. Wyświetl bazę danych");
        System.out.println("2. Wyświetl dany samochód");
        System.out.println("3. Dodaj samochód do bazy danych");
        System.out.println("4. Usuń samochód z bazy danych");
        System.out.println("5. Zmodyfikuj dane samochodu");
        System.out.println("6. Wyświetl daną markę");
        System.out.println("7. Wyświetl dany rocznik");
        System.out.println("8. Wyświetl samochody do podanej ceny");
        System.out.println("9. Zapisz i wyjdź");
        System.out.println("10. SYMULACJA PARKINGU");

        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();

        switch (temp) {
            case "1" -> {
                display();
            }
            case "2" -> {
                System.out.println("Proszę podać numer indeksu samochodu");
                temp = sc.nextLine();
                displayCar(temp);
            }
            case "3" -> {
                System.out.println("Proszę wprowadzić następujące dane");
                System.out.println("Nr silnika");
                int nr_silnika = Integer.parseInt(sc.nextLine());
                System.out.println("Marka");
                String marka = sc.nextLine();
                System.out.println("Typ");
                String typ = sc.nextLine();
                System.out.println("Data produkcji");
                int data_produkcji = Integer.parseInt(sc.nextLine());
                System.out.println("Cena");
                double cena = Double.parseDouble(sc.nextLine());
                System.out.println("Kolor");
                String kolor = sc.nextLine();
                System.out.println("Czas składowania");
                int skladowanie = Integer.parseInt(sc.nextLine());
                insert(new Auto(nr_silnika, marka, typ, data_produkcji,
                        cena, kolor, skladowanie));
                System.out.println("Auto zostało wprowadzone do bazy danych");
            }
            case "4" -> {
                System.out.println("Proszę podać numer indeksu samochodu");
                temp = sc.nextLine();
                remove(temp);
            }
            case "5" -> {
                System.out.println("Proszę podać numer indeksu samochodu");
                temp = sc.nextLine();
                modify(temp);
            }
            case "6" -> {
                System.out.println("Proszę podać markę samochodu");
                String marki = String.join(", ", bazaMarek);
                System.out.println(marki);
                temp = sc.nextLine();
                displayMake(temp);
            }
            case "7" -> {
                System.out.println("Proszę podać rocznik samochodu");
                String roczniki = String.join(", ", bazaRocznikow);
                System.out.println(roczniki);
                temp = sc.nextLine();
                displayDate(temp);
            }
            case "8" -> {
                System.out.println("Proszę podać maksymalną cenę");
                temp = sc.nextLine();
                displayPrice(temp);
            }
            case "9" -> {
                isRunning = false;
            }
            case "10" -> {
                simulation();
            }
        }
    }

    private void makeDatabase() {

        Random rand = new Random();

        do {
            Auto auto = new Auto(
                    rand.nextInt(1000,10000),
                    MARKI[rand.nextInt(MARKI.length)],
                    TYP[rand.nextInt(TYP.length)],
                    rand.nextInt(1950,2023),
                    rand.nextInt(10000, 500000),
                    KOLOR[rand.nextInt(KOLOR.length)],
                    rand.nextInt(25)
            );
            insert(auto);
        } while (rand.nextInt(1000) != 1);
    }

    private void remove(String stringIndex) {
        int index = Integer.parseInt(stringIndex);
    }

    private void modify(String stringIndex) {
        int index = Integer.parseInt(stringIndex);
    }

    private void insert(Auto auto) {
        int wartosc = auto.getNr_silnika();

        if (lista.isEmpty()) {
            lista.add(auto);
            return;
        }

        int index = -1;

        for (int i = lista.size() - 1; (i >= 0 && wartosc < lista.get(i).getNr_silnika()); i--) index = i;

        if (index!=-1) lista.add(index, auto);
        else lista.add(auto);
    }

    private void display() {
        for (Auto auto : lista) {
            System.out.println(auto);
        }
    }

    private void displayCar(String stringIndex) {
        int index = Integer.parseInt(stringIndex);
    }

    private void displayMake(String marka) {

    }

    private void displayDate(String stringDate) {
        int date = Integer.parseInt(stringDate);
    }

    private void displayPrice(String stringPrice) {
        double price = Double.parseDouble(stringPrice);
    }

    private void simulation() {

    }
}
