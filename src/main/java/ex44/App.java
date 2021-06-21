/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex44;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //Get the list of products from the file in a usable form
        List<Product> products = getDataFromFile();

        //Search for the products in that list
        List<Product> foundProducts = getProduct(products);

        //Print the list of found items
        printOutput(foundProducts);
    }

    private static void printOutput(List<Product> foundProducts) {
        for (int i = 0; i < foundProducts.size(); i++)
        {
            System.out.println("Name: "+foundProducts.get(i).getName());
            System.out.println("Price: "+foundProducts.get(i).getPrice());
            System.out.println("Quantity: "+foundProducts.get(i).getQuantity());
            System.out.print("\n");
        }
    }

    private static List<Product> getProduct(List<Product> products) {
        //Get the product the user is searching for

        //Create an instance of the ProductSearch class
        ProductSearch ps = new ProductSearch();

        //Create a String to hold the user's search term
        //and a list of Products to hold the results
        String searchTerm;
        List<Product> foundProducts = new ArrayList<>();

        //Create a flag to use in a while loop to keep prompting the user if
        //their search term doesn't match any known objects
        boolean foundFlag = false;

        //Loop to keep the user in the program until they enter a product name in the database
        while (!foundFlag)
        {
            System.out.println("What is the product name? ");
            searchTerm = in.nextLine();


            //Search for the user's product in the database
            foundProducts = ps.searchProducts(searchTerm, products);

            //If it's not null set the flag to True
            if (foundProducts != null) foundFlag = true;

            //If the loop completes without setting foundFlag to True, print an error
            if (!foundFlag) System.out.println("Sorry, that product was not found in our inventory.");
        }

        //Return the list of found products
        return foundProducts;
    }

    private static List<Product> getDataFromFile(){
        //Create a list to read the data into
        File inputFile = new File("exercise44_input.json");

        //Create a list of Product objects
        List<Product> products = new ArrayList<>();

        //Wrap the operation in a try/catch statement to handle any errors
        try {
            //Create a json elements for use in parsing the array
            JsonElement fileElement = JsonParser.parseReader(new FileReader(inputFile));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray jsonArrayOfProducts = fileObject.get("products").getAsJsonArray();

            //Loop through the array and parse the json into separate fields
            for (JsonElement productElement : jsonArrayOfProducts) {
                JsonObject productJsonObject = productElement.getAsJsonObject();
                String name = productJsonObject.get("name").getAsString();
                Double price = productJsonObject.get("price").getAsDouble();
                Integer quantity = productJsonObject.get("quantity").getAsInt();

                //Build a new Product and add it to a list of Products
                Product product = new Product(name, price, quantity);
                products.add(product);
            }
            //Catch any exceptions thrown and print ane error message and the stack trace
        } catch (FileNotFoundException e) {
            System.out.println("Could not parse data");
            e.printStackTrace();
        }

        //Return the list of products
        return products;
    }
}
