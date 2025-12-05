package it.unical.demacs;

public class App {
    public static void main(String[] args) {
        Algorithms alg = new Algorithms();
        String acronym = "CDL";
        String phrase = "Corso Di Laurea";
        System.out.println("The acronym matches: " + alg.checkAcronym(acronym, phrase));

        int[] array = new int[]{1, 8, 3, 2, 10};
        alg.sort(array);
        System.out.println("Sorted array: ");
        printArray(array);

    }

    private static void printArray(int[] array) {
        int n = array.length;
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
