package com.example.demo.controller;

import com.example.demo.dto.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/response")
    public Test getResponse() {
        Test test = new Test();
        test.setMessage("This is a message");

        logger.info("Response generated: {}", test);

        return test;  // Automatically serialized to JSON
    }
}