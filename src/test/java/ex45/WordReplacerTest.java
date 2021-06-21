/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex45;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordReplacerTest {

    //Create an instance of the WordReplacer class
    WordReplacer wr = new WordReplacer();

    @Test
    void replaceWord_should_replace_utilize_with_use() {

        //Create the input list
        List<String> input = new ArrayList<>();
        input.add("One should never utilize the word \"utilize\" in writing. Use \"use\" instead.");
        input.add("For example, \"She uses an IDE to write her Java programs\" instead of \"She");
        input.add("utilizes an IDE to write her Java programs\".");

        //Create the expected output
        List<String> expected = new ArrayList();
        expected.add("One should never use the word \"use\" in writing. Use \"use\" instead.");
        expected.add("For example, \"She uses an IDE to write her Java programs\" instead of \"She");
        expected.add("uses an IDE to write her Java programs\".");

        //Get the correct output
        List<String> result = wr.replaceWord(input, "utilize", "use");

        //Assert that every line of the expected output matches the actual output
        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void replaceWord_should_replace_arbitrary_words() {

        //Create the expected output
        List<String> input = new ArrayList<>();
        input.add("One should never utilize the word \"utilize\" in writing. Use \"use\" instead.");
        input.add("For example, \"She uses an IDE to write her Java programs\" instead of \"She");
        input.add("utilizes an IDE to write her Java programs\".");

        //Create the expected output
        List<String> expected = new ArrayList();
        expected.add("You should never utilize the word \"utilize\" in textual communications. Use \"use\" in the place.");
        expected.add("For instance, \"She uses Notepad++ to write her HTML programs\" in the place of \"She");
        expected.add("utilizes Notepad++ to write her HTML programs\".");

        //Randomly replace random words with other words at random
        List<String> result = wr.replaceWord(input, "example", "instance");
        result = wr.replaceWord(result, "One", "You");
        result = wr.replaceWord(result, "Java", "HTML");
        result = wr.replaceWord(result, "an IDE", "Notepad++");
        result = wr.replaceWord(result, "writing", "textual communications");
        result = wr.replaceWord(result, "instead", "in the place");

        //Assert that every line of the expected output matches the actual output
        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i), result.get(i));
        }
    }
}