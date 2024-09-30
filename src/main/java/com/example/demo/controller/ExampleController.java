package com.example.demo.controller;

import com.example.demo.dto.ExampleTableDTO;
import com.example.demo.entity.ExampleTable;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ExampleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

    private final ExampleTableService exampleTableService;

    public ExampleController(ExampleTableService exampleTableService) {
        this.exampleTableService = exampleTableService;
    }

    @GetMapping("/examples")
    public List<ExampleTable> getAllExamples() {
        try {
            return exampleTableService.getAllExamples();
        } catch (ResourceNotFoundException e) {
            logger.error("Error fetching examples: {}", e.getMessage());
            throw e;  // Rethrow the exception to be handled by GlobalExceptionHandler
        }
    }

    @GetMapping("/examples-format-date")
    public List<ExampleTableDTO> getAllWithFormattedDate() {
        try {
            return exampleTableService.findAllWithFormattedDate();
        } catch (ResourceNotFoundException e) {
            logger.error("Error fetching examples with formatted date: {}", e.getMessage());
            throw e;  // Rethrow the exception to be handled by GlobalExceptionHandler
        }
    }
}