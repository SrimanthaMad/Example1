package com.srimantha;

import com.srimantha.fizzbuzz.FizzBuzz;
import com.srimantha.fizzbuzz.ThreeFiveFizzBuzz;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Test class to test the implementation of the ThreeFiveFizzBuzz class
 */

public class FizzBuzzTest {
    FizzBuzz fizzBuzz;
    @Before
    public void initialize() {
        fizzBuzz= new ThreeFiveFizzBuzz();
    }
    @Test
    public void testGetFizzBuzzList(){
        Map expectedMap = new LinkedHashMap<String, String>();
        expectedMap.put("0", "FizzBuzz");
        expectedMap.put("1", "1");
        expectedMap.put("2", "2");

        Map actualMap = fizzBuzz.getFizzBuzzList(0,2);

        assertEquals("Expected map not equal to actual",expectedMap, actualMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFizzBuzzListNegativeStart(){
        fizzBuzz.getFizzBuzzList(-1,2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFizzBuzzListNegativeEnd(){
        fizzBuzz.getFizzBuzzList(1,-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFizzBuzzListStartGreaterThanEnd(){
        fizzBuzz.getFizzBuzzList(3,2);
    }


}