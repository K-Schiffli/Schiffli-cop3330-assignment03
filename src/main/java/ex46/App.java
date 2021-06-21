/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        
        //Create an instance of the WordCounter class
        WordCounter wc = new WordCounter();

        //Get the list of strings from the file
        List<String> input = getDataFromFile();
        
        //Count the number of words with the countWords method
        Map<String, String> output = wc.countWords(input);
        
        //Print the output to the console
        printOutput(output);

    }

    private static void printOutput(Map<String, String> output) {

        //Use a sorted stream to print the keys and values
        output.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));
    }

    private static List<String> getDataFromFile() {

        //Create a list to read the data into
        List<String> data = new ArrayList<>();

        //Wrap the file reading in a try/catch in case the file can't be read
        try {
            //Open the file to read
            File inputFile = new File("exercise46_input.txt");
            //Create a scanner to read the file
            Scanner in = new Scanner(inputFile);
            //loop through the file and read it while there are still new lines to read
            for (int i = 0; in.hasNextLine(); i++) {
                data.add(in.nextLine());
            }
            //Remember to close the file
            in.close();

            //Catch the exception thrown if the file fails to open, print an error message, and the stack trace
        } catch (FileNotFoundException e) {
            System.out.println("Could not read from file.");
            e.printStackTrace();
        }

        //Return the list of strings read in
        return data;
    }
}