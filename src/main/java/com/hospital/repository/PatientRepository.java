package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer> {

}
