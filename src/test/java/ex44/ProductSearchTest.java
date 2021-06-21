/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex44;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductSearchTest {

    @Test
    void searchProducts_should_find_the_searched_for_product() {
        ProductSearch ps = new ProductSearch();

        List<Product> products = new ArrayList<>();
        products.add(new Product("Widget", 25.00, 5 ));
        products.add(new Product("Thing", 15.00, 5 ));
        products.add(new Product("Doodad", 5.00, 10 ));

        List<Product> expected = new ArrayList<>();
        expected.add(new Product("Doodad", 5.00, 10 ));


        List<Product> result = ps.searchProducts("Doodad", products);

        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i).getName(), result.get(i).getName());
            assertEquals(expected.get(i).getPrice(), result.get(i).getPrice());
            assertEquals(expected.get(i).getQuantity(), result.get(i).getQuantity());
        }
    }

    @Test
    void searchProducts_should_find_multiple_products() {
        ProductSearch ps = new ProductSearch();

        List<Product> products = new ArrayList<>();
        products.add(new Product("Widget", 25.00, 5 ));
        products.add(new Product("Thing", 15.00, 5 ));
        products.add(new Product("Doodad", 5.00, 10 ));
        products.add(new Product("Doodad", 10.00, 15 ));

        List<Product> expected = new ArrayList<>();
        expected.add(new Product("Doodad", 5.00, 10 ));
        expected.add(new Product("Doodad", 10.00, 15 ));


        List<Product> result = ps.searchProducts("Doodad", products);

        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i).getName(), result.get(i).getName());
            assertEquals(expected.get(i).getPrice(), result.get(i).getPrice());
            assertEquals(expected.get(i).getQuantity(), result.get(i).getQuantity());
        }
    }
}