package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.CiudadService;
import com.example.service.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@GetMapping
	public String listDoctors() {
		return "doctor/list";
	}
}
