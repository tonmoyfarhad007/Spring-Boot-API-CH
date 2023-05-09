package com.example.twentyFourCoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twentyFourCoding.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}
