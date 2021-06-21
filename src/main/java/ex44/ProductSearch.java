/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex44;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
    public List<Product> searchProducts(String searchTerm, List<Product> products) {

        //Create a list of products to add found products to
        List<Product> foundProducts = new ArrayList<>();

        //create a flag to decide whether to return null or not
        boolean foundFlag = false;

        //Loop through the list of products and add them to the list
        //if they match the search term
        for (Product product : products) {
            if (product.getName().equals(searchTerm)) {
                foundProducts.add(product);
                foundFlag = true;
            }
        }

        //Either return the list of found products, or else return null
        if (foundFlag) return foundProducts;
        else return null;

    }
}
