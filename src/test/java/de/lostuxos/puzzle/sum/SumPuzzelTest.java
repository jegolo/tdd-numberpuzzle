package de.lostuxos.puzzle.sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumPuzzelTest {

    private SumPuzzel sumPuzzel = new SumPuzzel();

    @Test
    public void test_solve_simple_puzzle() {
        //Prepare
        //Given

        var summandA = new char[]{'A'};
        var summandB = new char[]{'A'};
        var summe = new char[]{'B'};

        //When
        var result = sumPuzzel.solvePuzzle(summandA, summandB, summe);

        //Then

        //{{'A':'1'},{'B':'2'})..{'A':'4'},{'B':'8'});
        var expected = new HashSet<HashMap<Character, Integer>>();
        for (int i=1;i<5;i++) {
            var value = new HashMap<Character, Integer>();
            value.put('A', i);
            value.put('B', 2 * i);
            expected.add(value);
        }

        assertEquals(expected, result);

    }

    @Test
    public void test_twoNumberPuzzle() {
        //Prepare
        //Given

        var summandA = new char[]{'A'};
        var summandB = new char[]{'B'};
        var summe = new char[]{'A'};

        //When
        var result = sumPuzzel.solvePuzzle(summandA, summandB, summe);

        //Then

        //{{'A':'1'},{'B':'2'})..{'A':'4'},{'B':'8'});
        var expected = new HashSet<HashMap<Character, Integer>>();
        for (int i=1;i<10;i++) {
            var value = new HashMap<Character, Integer>();
            value.put('A', i);
            value.put('B', 0);
            expected.add(value);
        }

        assertEquals(expected, result);

    }

    @Test
    public void test_threeNumberPuzzle() {
        //Prepare
        //Given

        var summandA = new char[]{'A'};
        var summandB = new char[]{'B'};
        var summe = new char[]{'C'};

        //When
        var result = sumPuzzel.solvePuzzle(summandA, summandB, summe);

        //Then
            
        //{{'A':'1'},{'B':'2'})..{'A':'4'},{'B':'8'});
        var expected = new HashSet<HashMap<Character, Integer>>();
        for (int a=0;a<10;a++) {
            for (int b=0;b<10;b++) {
                if (a!=b && a!=a+b && b!=a+b && a+b < 10) {
                    var value = new HashMap<Character, Integer>();
                    value.put('A', a);
                    value.put('B', b);
                    value.put('C', a+b);
                    expected.add(value);
                }
            }
        }

        assertEquals(expected, result);

    }

}