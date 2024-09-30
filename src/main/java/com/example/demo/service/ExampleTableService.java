package com.example.demo.service;

import com.example.demo.dto.ExampleTableDTO;
import com.example.demo.entity.ExampleTable;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ExampleTableRepository;
import com.example.demo.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleTableService {
    private static final Logger logger = LoggerFactory.getLogger(ExampleTableService.class);

    private final ExampleTableRepository exampleTableRepository;

    public ExampleTableService(ExampleTableRepository exampleTableRepository) {
        this.exampleTableRepository = exampleTableRepository;
    }

    public List<ExampleTable> getAllExamples() {
        logger.info("Fetching all examples");
        List<ExampleTable> examples = exampleTableRepository.findAll();
        if (examples.isEmpty()) {
            logger.warn("No examples found");
            throw new ResourceNotFoundException("No examples found");
        }
        logger.info("Successfully fetched {} examples", examples.size());
        return examples;
    }

    public List<ExampleTableDTO> findAllWithFormattedDate() {
        logger.info("Fetching all examples with formatted date");
        List<ExampleTable> exampleTableList = exampleTableRepository.findAll();
        if (exampleTableList.isEmpty()) {
            logger.warn("No examples with date found");
            throw new ResourceNotFoundException("No examples found with date found");
        }
        List<ExampleTableDTO> formattedExamples = exampleTableList.stream()
                .map(example -> new ExampleTableDTO(
                        example.getId(),
                        example.getName(),
                        DateTimeUtil.formatToIndianReadable(example.getCreatedAt())
                ))
                .collect(Collectors.toList());
        logger.info("Successfully fetched {} examples with formatted date", formattedExamples.size());
        return formattedExamples;
    }
}