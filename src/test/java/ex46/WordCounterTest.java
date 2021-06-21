/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex46;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
    WordCounter wc = new WordCounter();

    @Test
    void countWords_should_return_the_correct_counts_for_the_example() {

        //Create the input list
        List<String> input = new ArrayList<>();
        input.add("badger badger badger");
        input.add("badger mushroom");
        input.add("mushroom snake badger badger");
        input.add("badger");

        //Create the expected Map
        Map<String, String> expected = new HashMap<>();
        expected.put("badger", "*******");
        expected.put("mushroom", "**");
        expected.put("snake", "*");

        //Get the result
        Map<String, String> result = wc.countWords(input);

        //Assert that all of the words have the correct counts
        assertEquals(expected.get("badger"), result.get("badger"));
        assertEquals(expected.get("mushroom"), result.get("mushroom"));
        assertEquals(expected.get("snake"), result.get("snake"));
    }

    @Test
    void countWords_should_return_the_correct_counts_for_another_string() {

        //Create the input list
        //You used the Badger Song, I'm using The Macarena.
        //Fair is fair
        List<String> input = new ArrayList<>();
        input.add("Dale a tu cuerpo alegría Macarena");
        input.add("Que tu cuerpo es pa' darle alegría y cosa buena");
        input.add("Dale a tu cuerpo alegría, Macarena");
        input.add("Hey Macarena");

        //Create the expected Map
        Map<String, String> expected = new HashMap<>();
        expected.put("tu", "***");
        expected.put("Macarena", "***");
        expected.put("cuerpo", "***");
        expected.put("alegría", "***");
        expected.put("a", "**");
        expected.put("Dale", "**");
        expected.put("Que", "*");
        expected.put("darle", "*");
        expected.put("es", "*");
        expected.put("cosa", "*");
        expected.put("pa'", "*");
        expected.put("y", "*");
        expected.put("Hey", "*");
        expected.put("buena", "*");


        //Get the result
        Map<String, String> result = wc.countWords(input);

        //Assert that all of the words have the correct counts
        assertEquals(expected.get("Dale"), result.get("Dale"));
        assertEquals(expected.get("a"), result.get("a"));
        assertEquals(expected.get("tu"), result.get("tu"));
        assertEquals(expected.get("cuerpo"), result.get("cuerpo"));
        assertEquals(expected.get("alegría"), result.get("alegría"));
        assertEquals(expected.get("Macarena"), result.get("Macarena"));
        assertEquals(expected.get("Que"), result.get("Que"));
        assertEquals(expected.get("es"), result.get("es"));
        assertEquals(expected.get("pa'"), result.get("pa'"));
        assertEquals(expected.get("darle"), result.get("darle"));
        assertEquals(expected.get("y"), result.get("y"));
        assertEquals(expected.get("cosa"), result.get("cosa"));
        assertEquals(expected.get("buena"), result.get("buena"));
        assertEquals(expected.get("Hey"), result.get("Hey"));
    }
}