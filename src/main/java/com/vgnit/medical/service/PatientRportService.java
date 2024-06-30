package com.vgnit.medical.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.vgnit.medical.entity.PatientReport;
import com.vgnit.medical.repository.PatientReportRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class PatientRportService 
{
	@Autowired
	private PatientReportRepository patientReportRepository;

	public PatientReport addReportPatient(PatientReport patientReport )
	{
		return patientReportRepository.save(patientReport);
		
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
	
	public List<PatientReport> getAllRep(String keyword)
	{
		if(keyword!=null)
		{
			return patientReportRepository.getThisss(keyword);
		}
		else
		{
			return patientReportRepository.findAll();
		}
	}

	public PatientReport getParticularRep(Long id) 
	{
		Optional<PatientReport> findById = patientReportRepository.findById(id);
		return findById.get();
	}

	public void deleteRep(Long id)
	{
		patientReportRepository.deleteById(id);
	}

	public PatientReport addRep(PatientReport patientReport)
	{
		return patientReportRepository.save(patientReport);
	}

}
