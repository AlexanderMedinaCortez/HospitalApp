package com.example.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "doctores")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Debe ingresar su nombre")
	@Column(name = "nombre_completo", nullable = false, length = 45)
	private String fullName;

	@Size(min = 8, max = 8, message = "El numero debe tener 8 digitos")
	@NotEmpty(message = "Debe ingresar su DNI")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Past(message = "Fecha de colegiatura incorrecta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_colegiatura", nullable = false)
	private Date date;

	@Max(100)
	@Min(23)
	@Column(name = "edad", nullable = false)
	private int age;

	@Max(100)
	@Min(0)
	@Column(name = "tiempo_experiencia", nullable = false)
	private int experienceTime;

	@Transient
	private double survivalBonus;

	@ManyToOne
	@JoinColumn(name = "ciudad_id", nullable = false)
	private Ciudad ciudad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperienceTime() {
		return experienceTime;
	}

	public void setExperienceTime(int experienceTime) {
		this.experienceTime = experienceTime;
	}

	public double getSurvivalBonus() {
		return survivalBonus;
	}

	public void setSurvivalBonus(double survivalBonus) {
		this.survivalBonus = survivalBonus;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
}


