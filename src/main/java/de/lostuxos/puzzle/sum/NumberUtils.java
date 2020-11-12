package de.lostuxos.puzzle.sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberUtils {

    static public List<Character> convertStringToCharacterList(String input){
        var result = new ArrayList<Character>();

        for (char c : input.toCharArray()) {
            result.add(c);
        }
        return result;
    }

    public static Set<Character> retrieveAllCharacters(char[] summandA, char[] summandB, char[] summe) {
        Set<Character> result = new HashSet<>();
        result.addAll(getCharacters(summandA));
        result.addAll(getCharacters(summandB));
        result.addAll(getCharacters(summe));

        return result;
    }

    private static Set<Character> getCharacters(char[] summandA) {
        var set = IntStream.range(0, summandA.length).mapToObj(i -> summandA[i]).collect(Collectors.toSet());
        return set;
    }

    public static int convertToNumber(Map<Character, Integer> numberList, char[] text) {
        int result = 0;
        int decimal=1;
        for (int i=text.length-1; i>-1; i--) {
            result = result + numberList.get(text[i]) * decimal;
            decimal=decimal*10;
        }
        return result;
    }
}

