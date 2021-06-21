/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex43;

import java.util.Locale;
import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        WebsiteGenerator wg = new WebsiteGenerator();

        //Prompt for the site name
        String siteName = getString("Site name: ");

        //prompt for the site author
        String siteAuthor = getString("Author: ");

        //Create a folder for the project
        String folderResult = wg.createWebsiteFolder(siteName);

        //Ask if the user wants a folder for JavaScript
        //and create it if so
        String JSResult = "";
        boolean JSFlag = false;
        if (askBooleanQuestion("Do you want a folder for JavaScript? ")) {
            JSResult = wg.createJSFile(siteName);
            JSFlag = true;
        }

        //Ask if the user wants a folder for CSS
        //and create it if so
        String CSSResult = "";
        boolean CSSFlag = false;
        if (askBooleanQuestion("Do you want a folder for CSS? ")) {
            CSSResult = wg.createCSSFile(siteName);
            CSSFlag = true;
        }

        //Create the index.html file
        String indexResult = wg.createIndexFile(siteName, siteAuthor, JSFlag, CSSFlag);

        //Print output statements based on what files were created
        printOutput(folderResult, indexResult, JSResult, CSSResult);

    }

    private static void printOutput(String folderResult, String indexResult, String JSResult, String CSSResult) {
        System.out.println(folderResult);
        System.out.println(indexResult);
        System.out.println(JSResult);
        System.out.println(CSSResult);
    }

    private static boolean askBooleanQuestion(String question) {
        System.out.print(question);
        String input = in.nextLine();

        boolean validFlag = false;
        while (!validFlag)
        {
            if (!"Y".equals(input.toUpperCase(Locale.ROOT)) && !"N".equals(input.toUpperCase(Locale.ROOT)))
            {
                System.out.print("Please enter Y or N: ");
                input = in.nextLine();
            }
            else validFlag = true;
        }
        return "Y".equals(input.toUpperCase(Locale.ROOT));
    }

    private static String getString(String question) {
        System.out.print(question);
        return in.nextLine();
    }
}
