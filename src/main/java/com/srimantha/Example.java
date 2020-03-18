package com.srimantha;

import java.util.*;
import java.util.stream.IntStream;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * Created by srimantha on 17/03/2020.
 */

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

@RestController
@EnableAutoConfiguration
public class Example {


    public static void main(String[] args){
        SpringApplication.run(Example.class, args);
    }

    @RequestMapping("/getfizzbuzzlist/{start}/{end}")
    private  ResponseEntity<Map<String,String>>getFizzBuzzList(@PathVariable("start") int start, @PathVariable("end") int end) {
        Map map = new LinkedHashMap<String,String>();
        IntStream.rangeClosed(start, end).mapToObj(x -> {
            if ((x % 3 == 0 || ("" + x).contains("3")) && (x % 5 == 0 || ("" + x).contains("5"))) {
                return new Entry(""+ x,"FizzBuzz");
            }else if (x % 3 == 0 || ("" + x).contains("3")) {
                return new Entry(""+ x,"Fizz");
            } else if (x % 5 == 0 || ("" + x).contains("5")) {
                return new Entry(""+ x,"Buzz");
            } else {
                return new Entry(""+ x,""+ x);
            }
        }).forEach(x -> map.put(x.key, x.value));
        return new ResponseEntity(map, HttpStatus.OK);
    }

}
