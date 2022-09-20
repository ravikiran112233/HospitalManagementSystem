package com.hospital.service;

import java.util.List;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;

public interface HospitalService {
	
	
	public Patient showPatientInformation(Integer Id);
    public boolean saveDoctorInformation(Doctor doctor);
    public boolean savePatientInformation(Patient patient);
    public List<Patient> getPatientListOfDoctor(String name,Doctor doctor);
    public List<Doctor> getDoctors();
	public Doctor showDoctorInformation(String name);
	
	 

}
