package de.lostuxos.puzzle.sum;

import javax.swing.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumPuzzel {

    public Set<Map<Character, Integer>> solvePuzzle (char[] summandA, char[] summandB, char[] summe) {
        Set<Character> allCharacters = NumberUtils.retrieveAllCharacters(summandA, summandB, summe);

        // Result
        Set<Map<Character, Integer>> resultList = new HashSet<>();

        //We hava only two characters

        Map<Character, Integer> numberMap = characterListMap(allCharacters);

        rekuListRun(numberMap, allCharacters, summandA, summandB, summe, resultList);
        return  resultList;
    }



    private Map<Character, Integer> characterListMap(Collection<Character> characters) {
       return characters.stream().collect(Collectors.toMap(Function.identity(), a -> 0));
    }


    private void rekuListRun(Map<Character, Integer> numberList, Set<Character> characters, char[] summandA, char[]summandB, char[] summe, Set<Map<Character, Integer>> results) {
        if (allNumbersNotEquals(numberList) && proof(numberList,summandA,summandB,summe)) {
            results.add(numberList);
            return;
        }

        var characters1 = new HashSet<Character>(characters);
        if (!characters1.isEmpty()) {
            char c = characters1.stream().findFirst().get();
            characters1.remove(c);

            for (int i=0;i<=9;i++) {
                var duplicate = new HashMap<>(numberList);
                duplicate.put(c, i);
                rekuListRun(duplicate, characters1, summandA, summandB, summe, results);
            }
        }

    }

    private boolean allNumbersNotEquals(Map<Character, Integer> numberList) {
        return new HashSet<Integer>(numberList.values()).size() == numberList.size();
    }


    private boolean proof(Map<Character, Integer> numberList, char[] summandA, char[] summandB, char[] summe) {
        var number1 = NumberUtils.convertToNumber(numberList, summandA);
        var number2 = NumberUtils.convertToNumber(numberList, summandB);
        var number3 = NumberUtils.convertToNumber(numberList, summe);
        return number1 + number2 == number3;
    }

}
