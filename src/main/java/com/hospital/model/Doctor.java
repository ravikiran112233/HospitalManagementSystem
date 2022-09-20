package com.hospital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@JsonFilter("DoctorFilter")
public class Doctor {

	@Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    private Integer age;
    private String gender;
    private String field;
    private Integer patient_count = 0;

    @OneToMany
    private List<Patient> patients;

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatients(Patient patient) {
        patients.add(patient);
    }

    public Doctor() {
    }

	public Doctor(Integer id, String name, Integer age, String gender, String field, Integer patient_count,
			List<Patient> patients) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.field = field;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", field=" + field + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getPatient_count() {
		return patient_count;
	}

	public void setPatient_count(Integer patient_count) {
		this.patient_count = patient_count;
	}

	
	
    
    
}
