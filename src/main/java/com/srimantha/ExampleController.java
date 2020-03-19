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



@RestController
@EnableAutoConfiguration
public class ExampleController {


    public static void main(String[] args){
        SpringApplication.run(ExampleController.class, args);
    }

    @GetMapping("/izzbuzzlist")
    private  ResponseEntity<Map<String,String>>fizzBuzzList(@RequestParam("start") int start, @RequestParam("end") int end) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        return new ResponseEntity(fizzBuzz.getFizzBuzzList(start, end), HttpStatus.OK);
    }

}
