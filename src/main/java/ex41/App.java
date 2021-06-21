/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex41;

import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        //Create an instance of a new class that sorts the names
        NameSorter ns = new NameSorter();

        //Call a method that gets the names to be written that returns an array of strings
        String[] names = getNames();
        //Call a method from the NameSorter class that takes the list of names and returns them sorted
        String[] sortedNames = ns.sortNames(names);
        //Call a method that writes the named to a file
        printToFile(sortedNames);
    }

    private static void printToFile(String[] sortedNames) {
        //Enclose the file writing function in a try/catch in case the operation fails
        try {
            //Create an instance of the FileWriter class and pass it the name of the file
            FileWriter fw = new FileWriter("exercise41_output.txt");
            //Write the header of the file outside the loop, then use a loop to write the sorted names
            fw.write("Total of " + sortedNames.length + " names\n-----------------\n");
            for (int i = 0; i < sortedNames.length; i++) {
                fw.write(sortedNames[i] + "\n");
            }
            //Remember to close the file and let the user know it worked
            fw.close();
            System.out.println("Operation complete.");

        //Catch the exception thrown if the file fails to open, print an error message, and the stack trace
        } catch (IOException e) {
            System.out.println("Could not write to file.");
            e.printStackTrace();
        }
    }

    private static String[] getNames() {
        //Read in a list of names
        String[] names = {"Ling, Mai",
                "Johnson, Jim",
                "Zarnecki, Sabrina",
                "Jones, Chris",
                "Jones, Aaron",
                "Swift, Geoffrey",
                "Xiong, Fong"};
        return names;
    }
}