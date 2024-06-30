package com.vgnit.medical.service;

import java.util.List;

import com.vgnit.medical.entity.Patient;

public interface PatientService 
{
	Patient addPatient(Patient patient);
	
	List<Patient> getAllPatient(String keyword); 
	
	void deletePatient(Long id);
	
	Patient getPatientById(Long id);

	List<Patient> pp();
}
