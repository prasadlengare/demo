package com.example.demo.repository;

import com.example.demo.entity.ExampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleTableRepository extends JpaRepository<ExampleTable, Long> {

    // You can define custom queries here if needed
}