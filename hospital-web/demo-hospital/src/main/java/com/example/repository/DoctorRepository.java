package com.example.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query("Select count(d) From Doctor d where d.dni=?1")
	int verifyDoctor (String dni);
	
	@Query("Select d From Doctor d where d.dni=?1")
	List<Doctor> findDoctor (String dni);
}
