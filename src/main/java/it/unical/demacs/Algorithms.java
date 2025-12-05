package it.unical.demacs;

public class Algorithms {

    /**
     * Checks if a given acronym matches a phrase
     *
     * @param acronym The acronym to check
     * @param phrase  The full phrase to compare against
     * @return true if the acronym matches, false otherwise
     * @throws IllegalArgumentException if either input is null
     */
    public boolean checkAcronym(String acronym, String phrase) {
        if (acronym == null || phrase == null) {
            throw new IllegalArgumentException("Acronym and phrase cannot be null");
        }

        acronym = acronym.toUpperCase();
        String[] words = phrase.split("[\\s-]+");

        if (acronym.length() != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                continue;
            }

            if (words[i].charAt(0) != acronym.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Sorts a given non-null array
     *
     * @param array to ber ordered
     * @throws IllegalArgumentException if the input array is null
     */
    public void sort(int[] array) {

        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j > 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


}

