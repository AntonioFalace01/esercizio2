package it.unical.demacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmsTest {

    private Algorithms alg;

    @BeforeEach
    public void setUp() {
        alg = new Algorithms();
    }

    @Test
    public void insertNullAcronymOrNullPhrase(){
        assertThrows(IllegalArgumentException.class, () -> {
            alg.checkAcronym(null,"a");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            alg.checkAcronym("a",null);
        });
    }

    // --- Tests for checkAcronym ---

    @Test
    public void checkAcronymValidSimple() {
        assertTrue(alg.checkAcronym("ABC", "Alpha Beta Chi"));
    }

    @Test
    public void checkAcronymCaseInsensitive() {
        // acronym in lowercase should still match
        assertTrue(alg.checkAcronym("nasa", "National Aeronautics and Space"));
    }

    @Test
    public void checkAcronymDifferentLengthShouldReturnFalse() {
        assertFalse(alg.checkAcronym("AB", "Alpha Beta Chi"));
    }

    @Test
    public void checkAcronymWithHyphenInPhrase() {
        // phrase contains hyphens and should be split correctly
        assertTrue(alg.checkAcronym("SOTA", "State-of-the-Art"));
    }

    @Test
    public void checkAcronymWithExtraSpaces() {
        // multiple spaces should be handled by the split regex
        assertTrue(alg.checkAcronym("ABC", "  Alpha   Beta   Chi  "));
    }

    // --- Tests for sort ---

    @Test
    public void sortNullArrayThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            alg.sort(null);
        });
    }

    @Test
    public void sortSimpleArray() {
        int[] arr = {3, 1, 2};
        alg.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3}, arr);
    }

    @Test
    public void sortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4};
        alg.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr);
    }

    @Test
    public void sortSingleElementArray() {
        int[] arr = {42};
        alg.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void sortArrayWithDuplicates() {
        int[] arr = {4, 1, 2, 1};
        alg.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 4}, arr);
    }

}
