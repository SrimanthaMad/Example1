package com.srimantha;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Entry {
    String key;
    String value;
    public Entry(String key, String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

public class FizzBuzz {
    public Map<String, String> getFizzBuzzList(int start, int end) {
        if(start<0 || end < 0 || start > end){
            throw new IllegalArgumentException(String.format("Illegal Arguments supplied for start=%d or end=%d", start, end));
        }
        Map map = new LinkedHashMap<String, String>();
        IntStream.rangeClosed(start, end).mapToObj(x -> {
            if ((x % 3 == 0 || ("" + x).contains("3")) && (x % 5 == 0 || ("" + x).contains("5"))) {
                return new Entry("" + x, "FizzBuzz");
            } else if (x % 3 == 0 || ("" + x).contains("3")) {
                return new Entry("" + x, "Fizz");
            } else if (x % 5 == 0 || ("" + x).contains("5")) {
                return new Entry("" + x, "Buzz");
            } else {
                return new Entry("" + x, "" + x);
            }
        }).forEach(x -> map.put(x.key, x.value));
        return map;
    }
}
