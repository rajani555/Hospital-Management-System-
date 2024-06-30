package com.vgnit.medical.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.vgnit.medical.entity.Patient;
import com.vgnit.medical.repository.PatientRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class PatientServiceImpl implements PatientService 
{
	@Override
	public List<Patient> pp() 
	{
		return patientRepository.fp();
	}

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient)
	{
		Patient savePatient = patientRepository.save(patient);
		return savePatient;
	}

	// (*)
	public void removeSessionMessage()
	{
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg"); 
	}
	
	// (*)
	public void removeSessionMessage2()
	{
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		
		session.removeAttribute("msgd"); 
	}
	
	// (*)
	public void removeSessionMessage3()
	{
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		
		session.removeAttribute("msgu"); 
	}
	
	@Override
	public List<Patient> getAllPatient(String keyword)
	{
		if(keyword!=null)
		{
			return patientRepository.search(keyword);
		}
		else
		{
			return patientRepository.findAll();
		}
	}

	@Override
	public void deletePatient(Long id)
	{
		patientRepository.deleteById(id);
		
	}

	@Override
	public Patient getPatientById(Long id) 
	{
		Optional<Patient> findById = patientRepository.findById(id);
		Patient patient = findById.get();
		return patient;
	}

}
