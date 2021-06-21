/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex42;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public List<String[]> parseData(List<String> data) {

        //Create an array of strings to hold the parsed data
        String[] dataLine;
        //Create a list to hold the string arrays of parsed data
        List<String[]> splitData = new ArrayList<>();

        //Loop through the list, split the data based on commas, store that in an array,
        //then store the arrays in a list
        for (int i = 0; i < data.size(); i++)
        {
             dataLine = data.get(i).split(",", 100);
             splitData.add(dataLine);
        }

        //Return the list
        return splitData;
    }
}
