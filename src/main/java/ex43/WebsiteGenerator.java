/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WebsiteGenerator {
    public String createWebsiteFolder(String siteName) {

        //Create a new File object with the correct path and call the mkdir() function on it
        File fl = new File("website/"+siteName);
        boolean success = fl.mkdir();

        //If it succeeds, return a string saying it worked
        //If it doesn't, return a string saying it failed
        if (success) return "Created ./website/" + siteName;
        else return "Could not create ./website/"+siteName;

    }

    public String createIndexFile(String siteName, String siteAuthor, boolean JSFlag, boolean CSSFlag) {
        //Enclose the file writing function in a try/catch in case the operation fails
        try {
            //Create an instance of the FileWriter class and pass it the name of the file
            FileWriter fw = new FileWriter("website/"+siteName+"/index.html");

            //Write the HTML boilerplate, putting each element where it belongs
            fw.write("<!doctype html>\n<html lang=\"en\">\n<head>\n\t<meta charset=\"utf-8\">" +
                    "\n\t<title>"+siteName+"</title>" +
                    "\n\t<meta name=\"description\" content=\"Generated website template\">" +
                    "\n\t<meta name=\"author\" content=\""+siteAuthor+"\">\n");

            //If the user includes the CSS folder, include that in the index
            if (CSSFlag) fw.write("\n\t<link rel=\"stylesheet\" href=\"css/styles.css?v=1.0\">\n");
            fw.write("\n</head>\n\n<body>");

            //If the user includes the JS folder, include that in the index
            if(JSFlag) fw.write("\n\t<script src=\"js/scripts.js\"></script>");

            fw.write("\n</body>\n</html>");

            //Remember to close the file and let the user know it worked
            fw.close();
            return "Created ./website/"+siteName+"/index.html";
            //Catch the exception thrown if the file fails to open, print an error message, and the stack trace
        } catch (IOException e) {
            System.out.println("Could not write to file.");
            e.printStackTrace();
        }
        return "Could not create ./website/"+siteName+"/index.html";

    }

    public String createJSFile(String siteName) {

        //Create a new File object with the correct path and call the mkdir() function on it
        File fl = new File("website/"+siteName+"/js");
        boolean success = fl.mkdir();

        //If it succeeds, return a string saying it worked
        //If it doesn't, return a string saying it failed
        if (success) return "Created ./website/"+siteName+"/js";
        else return "Could not create ./website/"+siteName+"/js";

    }

    public String createCSSFile(String siteName) {

        //Create a new File object with the correct path and call the mkdir() function on it
        File fl = new File("website/"+siteName+"/css");
        boolean success = fl.mkdir();

        //If it succeeds, return a string saying it worked
        //If it doesn't, return a string saying it failed
        if (success) return "Created ./website/"+siteName+"/css";
        else return "Could not create ./website/"+siteName+"/css";

    }
}
