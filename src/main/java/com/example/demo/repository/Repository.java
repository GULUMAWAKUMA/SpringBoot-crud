package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.model;

public interface Repository  extends JpaRepository<model, String>{


}

