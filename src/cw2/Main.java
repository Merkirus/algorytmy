package cw2;

public class Main {

    public static void main(String[] args) {

    }

    static int[] nextPascalLine(int n) {

        int[] tablica = {1};

        while (n!=1) {
            int[] newTablica = new int[tablica.length+1];

            newTablica[0] = 1;
            newTablica[tablica.length] = 1;

            for (int i=1; i<tablica.length; i++) {
                newTablica[i] = tablica[i] + tablica[i-1];
            }

            n--;

            tablica = newTablica;
        }

        return tablica;
    }

    static int getSecondSmallest(int[] tablica) throws NoAnswerExcepiton {

        if (tablica.length < 2) throw new NoAnswerExcepiton();

        int last = tablica[0];
        int nextLast;

        int index=0;

        for (; index<tablica.length; index++) {
            if (last != tablica[index]) {
                if (tablica[index] > last) {
                    nextLast = tablica[index];
                } else {
                    nextLast = last;
                    last = tablica[index];
                    break;
                }
            }
        }

        return  last;
    }

    static void nextPermutation(int[] arr) {
        int min2;
        int min1;

        if (arr[0]>arr[1]) {
            min1 = arr[1];
            min2 = arr[0];
        } else {
            min1 = arr[0];
            min2 = arr[1];
        }

    }

}

class NoAnswerExcepiton extends Exception {
    void printErr() {
        System.out.println("Error");
    }
}
