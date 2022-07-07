package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Doctor;
import com.example.service.CiudadService;
import com.example.service.DoctorService;

import antlr.collections.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private CiudadService ciudadService;

	@GetMapping("/new")
	public String registerDoctor(Model model) {
		model.addAttribute("doctor", new Doctor());
		model.addAttribute("ciudades", ciudadService.listCity());
		return "doctor/form";
	}
	
	@GetMapping
	public String listDoctors(Model model) {
		model.addAttribute("doctor", new Doctor());
		model.addAttribute("doctores", doctorService.listDoctor());
		return "doctor/list";
	}

	@PostMapping("/register")
	public String registerDoctor(@Validated @ModelAttribute Doctor doctor, BindingResult result, Model model) {
		int rpta;
		if (result.hasErrors()) {
			model.addAttribute("ciudades", ciudadService.listCity());
			return "doctor/form";
		}

		rpta=doctorService.RegisterDoctor(doctor);
		
		if(rpta>0) {
			model.addAttribute("mensaje", "El numero de DNI ya existe");
			model.addAttribute("ciudades", ciudadService.listCity());
		} else {
			model.addAttribute("mensaje", "El registro nuevo doctor");
			model.addAttribute("doctor", new Doctor());
			model.addAttribute("ciudades", ciudadService.listCity());
		}
		return "doctor/form";
	}

	@PostMapping("/find")
	public String findDoctors(Model model, @ModelAttribute Doctor doctor) {
		model.addAttribute("doctores", doctorService.findDoctorForDni(doctor.getDni()));
		return "doctor/list";
	}
}
