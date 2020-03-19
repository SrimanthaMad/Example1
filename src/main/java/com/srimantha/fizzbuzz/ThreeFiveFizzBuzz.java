package com.srimantha.fizzbuzz;

import com.srimantha.fizzbuzz.FizzBuzz;
import org.springframework.stereotype.Component;

import java.util.function.IntFunction;


@Component
public class ThreeFiveFizzBuzz  extends FizzBuzz {


    protected IntFunction<Entry> getEntryIntFunction() {
        return x -> {
            if ((x % 3 == 0 || ("" + x).contains("3")) && (x % 5 == 0 || ("" + x).contains("5"))) {
                return new Entry("" + x, "FizzBuzz");
            } else if (x % 3 == 0 || ("" + x).contains("3")) {
                return new Entry("" + x, "Fizz");
            } else if (x % 5 == 0 || ("" + x).contains("5")) {
                return new Entry("" + x, "Buzz");
            } else {
                return new Entry("" + x, "" + x);
            }
        };
    }
}
