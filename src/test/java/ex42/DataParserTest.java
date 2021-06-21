/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package ex42;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    void parseData_should_correctly_parse_test_data() {
        //Create an instance of the data parser class
        DataParser dp = new DataParser();

        //create an input list containing strings of comma separated values
        List<String> input = new ArrayList<>();
        input.add ("Ling,Mai,55900");
        input.add ("Johnson,Jim,56500");
        input.add ("Jones,Aaron,46000");
        input.add ("Jones,Chris,34500");
        input.add ("Swift,Geoffrey,14200");
        input.add ("Xiong,Fong,65000");
        input.add ("Zarnecki,Sabrina,51500");

        //Create a list of expected arrays of strings
        String[] str1 = {"Ling","Mai","55900"};
        String[] str2 = {"Johnson", "Jim", "56500"};
        String[] str3 = {"Jones","Aaron","46000"};
        String[] str4 = {"Jones","Chris","34500"};
        String[] str5 = {"Swift","Geoffrey","14200"};
        String[] str6 = {"Xiong","Fong","65000"};
        String[] str7 = {"Zarnecki","Sabrina","51500"};
        List<String[]> expected = new ArrayList();
        expected.add (str1);
        expected.add (str2);
        expected.add (str3);
        expected.add (str4);
        expected.add (str5);
        expected.add (str6);
        expected.add (str7);

        //Parse the input data using the data parser class
        List<String[]> result = dp.parseData(input);
        //Loop through both lists and set a flag if they are ever not equal to one another
        boolean foundDifference = false;
        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i)[0], result.get(i)[0]);
            assertEquals(expected.get(i)[1], result.get(i)[1]);
            assertEquals(expected.get(i)[2], result.get(i)[2]);
        }
    }


    @Test
    void parseData_should_correctly_parse_more_test_data() {
        //Create an instance of the data parser class
        DataParser dp = new DataParser();

        //create an input list containing strings of comma separated values
        List<String> input = new ArrayList<>();

        input.add ("Romero,Melinda,22300");
        input.add ("Lopez,Casey,24300");
        input.add ("Freeman,Roger,50000");
        input.add ("Gilbert,Hilda,27000");
        input.add ("Burns,Jermaine,64200");
        input.add ("Francis,James,55600");
        input.add ("Osborne,Duane,93900");
        input.add ("Massey,Greg,54500");
        input.add ("Ross,Kristina,76200");
        input.add ("Adams,Felix,56000");

        //Create a list of expected arrays of strings
        String[] str1 = {"Romero","Melinda","22300"};
        String[] str2 = {"Lopez","Casey","24300"};
        String[] str3 = {"Freeman","Roger","50000"};
        String[] str4 = {"Gilbert","Hilda","27000"};
        String[] str5 = {"Burns","Jermaine","64200"};
        String[] str6 = {"Francis","James","55600"};
        String[] str7 = {"Osborne","Duane","93900"};
        String[] str8 = {"Massey","Greg","54500"};
        String[] str9 = {"Ross","Kristina","76200"};
        String[] str10 = {"Adams","Felix","56000"};
        List<String[]> expected = new ArrayList();
        expected.add (str1);
        expected.add (str2);
        expected.add (str3);
        expected.add (str4);
        expected.add (str5);
        expected.add (str6);
        expected.add (str7);
        expected.add (str8);
        expected.add (str9);
        expected.add (str10);

        //Parse the input data using the data parser class
        List<String[]> result = dp.parseData(input);
        //Loop through both lists and assert that every element of every array in both lists are the same
        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i)[0], result.get(i)[0]);
            assertEquals(expected.get(i)[1], result.get(i)[1]);
            assertEquals(expected.get(i)[2], result.get(i)[2]);
        }
    }
}