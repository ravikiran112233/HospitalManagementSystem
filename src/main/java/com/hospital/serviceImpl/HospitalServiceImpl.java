package com.hospital.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.service.HospitalService;

@Repository
@Transactional
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient showPatientInformation(Integer Id) {
		return patientRepository.findById(Id).get();
	}

	@Override
	public boolean saveDoctorInformation(Doctor doctor) {
		 doctorRepository.save(doctor);
		 return true;
	}

	@Override
	public boolean savePatientInformation(Patient patient) {
		Doctor doctor = doctorRepository.findByName(patient.getDoctor_name());
		doctor.addPatients(patient);
		patientRepository.save(patient);
		doctor.setPatient_count(null);
		return true;
	}

	@Override
	public List<Patient> getPatientListOfDoctor(String name, Doctor doctor) {
		return doctor.getPatients();
	}

	@Override
	public List<Doctor> getDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}

	@Override
	public Doctor showDoctorInformation(String name) {
		return doctorRepository.findByName(name);
	}
	
	
   

}
