package de.lostuxos.puzzle.sum;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumPuzzel {

    public List<Map<Character, Integer>> solvePuzzle (char[] summandA, char[] summandB, char[] summe) {
        Set<Character> allCharacters = NumberUtils.retrieveAllCharacters(summandA, summandB, summe);

        var numberMap = new HashMap<Character, List<Integer>>();
        for (Character c : allCharacters) {

            List<Integer> values = new ArrayList<>();
            for (int i = 0; i<10;i++) {
                values.add(i);
            }
            numberMap.put(c, values);

        }

        return rekuSolve(numberMap, summandA, summandB, summe);

    }

    private List<Map<Character, Integer>> rekuSolve(HashMap<Character, List<Integer>> numberMap, char[] summandA, char[] summandB, char[] summe) {


    }

    /*
    // Utility function to swap two characters in a character array
    private static void swap(int[] ch, int i, int j)
    {
        char temp = int[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    // Recursive function to generate all permutations of a String
    private static void permutations(char[] ch, int currentIndex)
    {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }

        for (int i = currentIndex; i < ch.length; i++)
        {
            swap(ch, currentIndex, i);
            permutations(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }
    */
}
