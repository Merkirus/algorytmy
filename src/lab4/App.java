package lab4;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FullStackException, EmptyStackException {

        Nawiasy nawiasy = new Nawiasy();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Proszę wybrać numer: ");
            System.out.println("1. Wprowadzenie wyrażenia (nawiasy)");
            System.out.println("2. Wprowadzenie wyrażenia (palindrom)");
            System.out.println("3. Kopia stosu (poprzez 2x odwrócenie)");
            System.out.println("4. Zakończenie programu");

            Scanner sc = new Scanner(System.in);

            String wybor = sc.nextLine();

            switch (wybor) {
                case "1" -> {
                    System.out.println("Proszę wrowadzić tekst");
                    wybor = sc.nextLine();
                    if (nawiasy.nawiasyZrownowazone(wybor)) {
                        System.out.println("Wyrażenie poprawnie zrównoważone");
                    } else {
                        System.out.println("Wyrażenie nie jest zrównoważone");
                    }
                }
                case "2" -> {
                    System.out.println("Proszę wprowadzić tekst");
                    wybor = sc.nextLine();
                    ArrayStack<Character> arrayStack = new ArrayStack<>(wybor.length());
                    char[] chars = new char[wybor.length()];
                    wybor.getChars(0, wybor.length(), chars, 0);
                    for (char c :  chars) arrayStack.push(c);
                    if (arrayStack.equals(arrayStack.reverseStack())) {
                        System.out.println("Wyrażenie jest palindromem");
                    } else {
                        System.out.println("Wyrażenie nie jest palindromem");
                    }
                }
                case "3" -> {
                    //TODO 1
                    System.out.println("Proszę wprowadzić tekst");
                    wybor = sc.nextLine();
                    ArrayStack<Character> arrayStack = new ArrayStack<>(wybor.length());
                    char[] chars = new char[wybor.length()];
                    wybor.getChars(0, wybor.length(), chars, 0);
                    for (char c :  chars) arrayStack.push(c);
                    ArrayStack<Character> temp = arrayStack.reverseStack();
                    ArrayStack<Character> result = temp.reverseStack();
                    char[] toPrint = new char[wybor.length()];
                    for (int i=wybor.length()-1; !result.isEmpty(); i--) {
                        toPrint[i] = result.pop();
                    }
                    System.out.println(toPrint);
                    //TODO 2
//                    System.out.println("Proszę wprowadzić tekst");
//                    wybor = sc.nextLine();
//                    ArrayStack<Character> arrayStack = new ArrayStack<>(wybor.length());
//                    char[] chars = new char[wybor.length()];
//                    wybor.getChars(0, wybor.length(), chars, 0);
//                    for (char c :  chars) arrayStack.push(c);
//
//                    char[] temp = new char[arrayStack.size()];
//                    ArrayStack<Character> result = arrayStack.reverseStack();
//                    for (int i=0; !result.isEmpty(); i++) {
//                        temp[i] = result.pop();
//                    }
//                    for (char c : temp) {
//                        result.push(c);
//                    }
//                    char[] toPrint = new char[wybor.length()];
//                    for (int i=wybor.length()-1; !result.isEmpty(); i--) {
//                        toPrint[i] = result.pop();
//                    }
//                    System.out.println(toPrint);
                }
                case "4" -> isRunning = false;
                default -> {
                }
            }
        }

    }
}
