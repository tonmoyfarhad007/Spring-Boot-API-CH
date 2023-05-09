package com.example.twentyFourCoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twentyFourCoding.model.PizzaType;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType, Long>{

}
