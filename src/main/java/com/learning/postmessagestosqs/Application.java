package com.learning.postmessagestosqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.learning.postmessagestosqs.controller","com.learning.postmessagestosqs.publisher","com.learning.postmessagestosqs.service","com.learning.postmessagestosqs.configuration"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
