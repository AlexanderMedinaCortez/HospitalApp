package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long>{

}
