package it.unical.demacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
