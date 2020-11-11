package de.lostuxos.puzzle.sum;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NumberUtilsTest {

    @Test
    public void test_convert_to_list() {
        //PREPARE

        //GIVEN
        var input = "ABC";
        var characterArray = new Character[] { Character.valueOf('A'), Character.valueOf('B'), Character.valueOf('C') };
        var expected = Arrays.asList(characterArray);

        //WHEN
        var result = NumberUtils.convertStringToCharacterList(input);

        //THEN
        assertEquals(expected, result);
    }

    @Test
    void retrieveAllCharacters() {
        //Prepare

        //GIVEN
        char[] summand1 = new char[]{'s','e','n','d'};
        char[] summand2 = new char[]{'m','o','r','e'};
        char[] summe = new char[]{'m','o','n','e','y'};

        //WHEN
        var result = NumberUtils.retrieveAllCharacters(summand1, summand2, summe);

        //THEN
        assertNotNull(result);
        var expected = new HashSet<Character>(Arrays.asList('s','e','n','d','m','o','r','y'));
        assertEquals(expected, result);

    }
}