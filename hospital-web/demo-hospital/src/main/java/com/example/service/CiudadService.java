package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Ciudad;
import com.example.repository.CiudadRepository;

@Service
public class CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;

	public List<Ciudad> listCity() {
		return ciudadRepository.findAll();
	}
}
