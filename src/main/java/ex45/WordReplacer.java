/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex45;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordReplacer {

    public List<String> replaceWord(List<String> input, String find, String replace) {

        //Create a list of strings to hold the output
        List<String> outputList = new ArrayList<>();

        //Loop through the list and use Regex and the Matcher object to
        //find and replace all instances of the word "utilize" with the word "use"
        for (String s : input) {
            Pattern findWord = Pattern.compile(find);
            Matcher matcher = findWord.matcher(s);
            String output = matcher.replaceAll(replace);

            //Add each replaced string to a new output list
            outputList.add(output);

        }

        //Return the list of strings
        return outputList;
    }
}
