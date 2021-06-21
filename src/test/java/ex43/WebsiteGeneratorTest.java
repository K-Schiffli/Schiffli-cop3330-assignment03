/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex43;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {
    WebsiteGenerator wg = new WebsiteGenerator();


    @Test
    void WebsiteGenerator_should_generate_a_proper_website() {
        wg.createWebsiteFolder("TestSite");
        wg.createJSFile("TestSite");
        wg.createCSSFile("TestSite");
        wg.createIndexFile("TestSite", "TestSite", true, true);
        List<String> html = getDataFromFile();

        List<String> expected = new ArrayList<>();
        expected.add("<!doctype html>");
        expected.add("<html lang=\"en\">");
        expected.add("<head>");
        expected.add("\t<meta charset=\"utf-8\">");
        expected.add("\t<title>TestSite</title>");
        expected.add("\t<meta name=\"description\" content=\"Generated website template\">");
        expected.add("\t<meta name=\"author\" content=\"TestSite\">");
        expected.add("");
        expected.add("\t<link rel=\"stylesheet\" href=\"css/styles.css?v=1.0\">");
        expected.add("");
        expected.add("</head>");
        expected.add("");
        expected.add("<body>");
        expected.add("\t<script src=\"js/scripts.js\"></script>");
        expected.add("</body>");
        expected.add("</html>");

        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), html.get(i));

    }

    @Test
    void createJSFile_should_create_the_JavaScript_file() {
        File jsFile = new File("website/TestSite/js");

        boolean validFlag = jsFile.isDirectory();

        assertTrue(validFlag);
    }

    @Test
    void createCSSFile_should_create_the_CSS_file() {
        File cssFile = new File("website/TestSite/css");

        boolean validFlag = cssFile.isDirectory();

        assertTrue(validFlag);
    }

    private static List<String> getDataFromFile() {

        //Create a list to read the data into
        List<String> data = new ArrayList<>();

        //Wrap the file reading in a try/catch in case the file can't be read
        try {
            //Open the file to read
            File inputFile = new File("website/TestSite/index.html");
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