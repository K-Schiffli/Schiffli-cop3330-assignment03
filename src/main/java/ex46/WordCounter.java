/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    public Map<String, String> countWords(List<String> input) {
        //Create a Map to store the output data.
        Map<String, String> countMap = new HashMap<String, String>();

        //Loop through the List of strings
        for (String s : input) {
            //Split each string into different words
            String[] wordArray = s.split(" ");

            //Loop through the new array of single words.
            //If a word hasn't been seen before, add it to the list. If it has, add a star to its entry
            for (int i = 0; i < wordArray.length; i++)
            {
                if (!countMap.containsKey(wordArray[i]))
                {
                    countMap.put(wordArray[i], "*");
                }
                else
                {
                    String starCount = countMap.get(wordArray[i]);
                    countMap.remove(wordArray[i]);
                    countMap.put(wordArray[i], starCount + "*");
                }
            }
        }

        //Return the map
        return countMap;
    }
}
