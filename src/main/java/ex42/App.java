/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //Create an instance of a class to parse the data
        DataParser dp = new DataParser();

        //Read the data from the file into a list of strings
        List<String> names = getDataFromFile();

        //Call the parseData method from the DataParser class
        List<String[]> parsedList = dp.parseData(names);

        //Print the parsed data to the console
        printOutput(parsedList);
    }

    private static void printOutput(List<String[]> parsedList) {
        //Print the header outside of the loop
        System.out.print("Last        First       Salary" +
                       "\n------------------------------\n");
        //Use a loop to print every member of the parsed list
        for(int i = 0; i < parsedList.size(); i++)
        {
            System.out.printf("%-10s\t%-10s\t%-10s\n", parsedList.get(i)[0], parsedList.get(i)[1], parsedList.get(i)[2]);
        }
    }

    private static List<String> getDataFromFile() {

        //Create a list to read the data into
        List<String> data = new ArrayList<>();

        //Wrap the file reading in a try/catch in case the file can't be read
        try {
            //Open the file to read
            File inputFile = new File("exercise42_input.txt");
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