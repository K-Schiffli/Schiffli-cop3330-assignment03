/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //Create an instance of the WordReplacer class
        WordReplacer wr = new WordReplacer();

        //Get the input from the file
        List<String> input = getDataFromFile();
        //Call the replaceUtilize method to replace every instance of
        //the word "Utilize" with "Use"
        List<String> outputList = wr.replaceWord(input, "utilize", "use");
        printToFile(outputList);
    }


    private static List<String> getDataFromFile() {

        //Create a list to read the data into
        List<String> data = new ArrayList<>();

        //Wrap the file reading in a try/catch in case the file can't be read
        try {
            //Open the file to read
            File inputFile = new File("exercise45_input.txt");
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

    private static void printToFile(List<String> output) {
        //Enclose the file writing function in a try/catch in case the operation fails
        try {
            //Create an instance of the FileWriter class and pass it the name of the file
            FileWriter fw = new FileWriter("exercise45_output.txt");
            for (String s : output) {
                fw.write(s + "\n");
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
}
