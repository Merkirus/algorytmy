package lab4;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FullStackException, EmptyStackException {

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Proszę wybrać numer: ");
            System.out.println("1. Wprowadzenie wyrażenia");
            System.out.println("2. Zakończenie programu");

            Scanner sc = new Scanner(System.in);

            String wybor = sc.nextLine();

            switch (wybor) {
                case "1" -> {
                    System.out.println("Proszę wrowadzić tekst");
                    wybor = sc.nextLine();
                    if (Nawiasy.nawiasyZrownowazone(wybor)) {
                        System.out.println("Wyrażenie poprawne zrównoważone");
                    } else {
                        System.out.println("Wyrażenie nie jest zrównoważone");
                    }
                }
                case "2" -> isRunning = false;
                default -> {
                }
            }
        }

    }
}
