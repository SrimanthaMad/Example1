package com.srimantha;

import java.util.*;

import com.srimantha.fizzbuzz.FizzBuzz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Rest Controller for the sample application. This class will be the entry point to
 * all the resources defined in this service
 */

@EnableSwagger2
@EnableAutoConfiguration
@RestController
@RequestMapping("/api/v1")
@ComponentScan({"com.srimantha"})
@Api(value="Example Controller")
public class ExampleController {

    @Autowired
    private FizzBuzz fizzBuzz;

    @GetMapping("/fizzbuzzlist")
    @ApiOperation(value = "Given and start and end of an integer input stream return a Fizz buzz mapping to each integer in that stream", response = Map.class)
    private  ResponseEntity<Map<String,String>>fizzBuzzList(@RequestParam("start") int start, @RequestParam("end") int end) {
        return new ResponseEntity(fizzBuzz.getFizzBuzzList(start, end), HttpStatus.OK);
    }

}
