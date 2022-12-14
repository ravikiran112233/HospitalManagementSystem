package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospital.model.Doctor;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface DoctorRepository extends CrudRepository<Doctor,Integer>  {

	Doctor findByName(String doctor_name);

}
