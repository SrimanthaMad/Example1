package com.srimantha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Main class
 */
public class ExampleMain {

    public static void main(String[] args){
        SpringApplication.run(ExampleController.class, args);
    }
}
