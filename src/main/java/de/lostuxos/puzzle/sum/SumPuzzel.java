package de.lostuxos.puzzle.sum;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumPuzzel {

    public List<Map<Character, Integer>> solvePuzzle (char[] summandA, char[] summandB, char[] summe) {
        Set<Character> allCharacters = NumberUtils.retrieveAllCharacters(summandA, summandB, summe);

        // Result
        List<Map<Character, Integer>> resultList = new ArrayList<>();

        //We hava only two characters

        char character1 = (char) allCharacters.toArray()[0];
        char character2 = (char) allCharacters.toArray()[1];
        for (int character1Value = 0; character1Value < 10; character1Value++) {
            for (int character2Value = 0; character2Value < 10; character2Value++) {
                if (character1Value != character2Value) {
                    var first = character1 == summandA[0] ? character1Value : character2Value;
                    var second = character1 == summandB[0] ? character1Value : character2Value;
                    var sum = character1 == summe[0] ? character1Value : character2Value;

                    if (first + second == sum) {
                        Map<Character, Integer> resultMap = new HashMap<>();
                        resultMap.put(character1, character1Value);
                        resultMap.put(character2, character2Value);
                        resultList.add(resultMap);
                    }

                }
            }
        }
        return  resultList;
    }



/**
 *     var numberMap = new HashMap<Character, List<Integer>>();
 *         for (Character c : allCharacters) {
 *
 *             List<Integer> values = new ArrayList<>();
 *             for (int i = 0; i<10;i++) {
 *                 values.add(i);
 *             }
 *             numberMap.put(c, values);
 *
 *         }
 */
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
