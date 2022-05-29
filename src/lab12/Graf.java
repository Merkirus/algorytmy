package lab12;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graf {

    private ArrayList<LinkedList<Pair>> arrayList = new ArrayList<>();

    class Pair {
        int sasiad;
        int waga;

        @Override
        public String toString() {
            return sasiad + " waga: " + waga;
        }
    }

    public Graf(int n) {
        arrayList.ensureCapacity(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(new LinkedList<>());
        }
    }

    public ArrayList<LinkedList<Pair>> getArrayList() {
        return arrayList;
    }

    public void dodajSasiedztwo(int indeks, int sasiad, int waga) {
        Pair pair = new Pair();
        pair.sasiad = sasiad;
        pair.waga = waga;
        arrayList.get(indeks).add(pair);
    }

    public void wyswietl() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                System.out.print(arrayList.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }
}
