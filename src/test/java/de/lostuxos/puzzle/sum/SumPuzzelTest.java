package de.lostuxos.puzzle.sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

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
        var expected = new ArrayList<HashMap<Character, Integer>>();
        for (int i=1;i<5;i++) {
            var value = new HashMap<Character, Integer>();
            value.put('A', i);
            value.put('B', 2 * i);
            expected.add(value);
        }

        assertEquals(expected, result);

    }

}