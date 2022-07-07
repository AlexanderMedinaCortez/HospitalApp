package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Doctor;
import com.example.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> listDoctor() {
		double survivalBonus;
		List<Doctor> doctores = doctorRepository.findAll();

		for (Doctor doctor : doctores) {

			survivalBonus = 20 * doctor.getAge() + 100 * doctor.getExperienceTime();
			doctor.setSurvivalBonus(survivalBonus);
		}

		return doctores;
	}

	public int RegisterDoctor(Doctor doctor) {
		int verifyDoctor = doctorRepository.verifyDoctor(doctor.getDni());
		
		if (verifyDoctor == 0) 
			doctorRepository.save(doctor);

		return verifyDoctor;
	}
	
	public List<Doctor> findDoctorForDni(String dni) {
		double survivalBonus;
		List<Doctor> doctores = doctorRepository.findDoctor(dni);

		for (Doctor doctor : doctores) {

			survivalBonus = 20 * doctor.getAge() + 100 * doctor.getExperienceTime();
			doctor.setSurvivalBonus(survivalBonus);
		}

		return doctores;
	}
}
