/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex41;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest {

    @Test
    void sortNames_should_return_correctly_sorted_names() {
        //Create an instance of the sorting class
        NameSorter ns = new NameSorter();

        //Create an unsorted input array
        String[] input = {"Ling, Mai",
                "Johnson, Jim",
                "Zarnecki, Sabrina",
                "Jones, Chris",
                "Jones, Aaron",
                "Swift, Geoffrey",
                "Xiong, Fong"};

        //Create a sorted expected array
        String[] expected = {
                "Johnson, Jim",
                "Jones, Aaron",
                "Jones, Chris",
                "Ling, Mai",
                "Swift, Geoffrey",
                "Xiong, Fong",
                "Zarnecki, Sabrina"};

        //Assert that the result of sorting the first array matches the second
        assertArrayEquals(expected, ns.sortNames(input));
    }

    @Test
    void sortNames_should_return_more_correctly_sorted_names() {
        //Create an instance of the sorting class
        NameSorter ns = new NameSorter();

        //Create an unsorted input array
        String[] input = {"Rogers, Elias",
                "Powell, Maggie",
                "Scott, Gary",
                "Barrett, Tracey",
                "Phillips, Misty",
                "Mccoy, Erik",
                "Hubbard, Mamie",
                "Farmer, Shelley",
                "Cain, Doreen",
                "Mccormick, Troy"};

        //Create a sorted expected array
        String[] expected = {"Barrett, Tracey",
                "Cain, Doreen",
                "Farmer, Shelley",
                "Hubbard, Mamie",
                "Mccormick, Troy",
                "Mccoy, Erik",
                "Phillips, Misty",
                "Powell, Maggie",
                "Rogers, Elias",
                "Scott, Gary"};

        //Assert that the result of sorting the first array matches the second
        assertArrayEquals(expected, ns.sortNames(input));
    }
}