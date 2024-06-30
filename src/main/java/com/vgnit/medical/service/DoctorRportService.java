package com.vgnit.medical.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.vgnit.medical.entity.DoctorReport;
import com.vgnit.medical.repository.DoctorReportRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class DoctorRportService
{
	@Autowired
	private DoctorReportRepository doctorReportRepository;
	
	public DoctorReport addReportDocter(DoctorReport doctorReport)
	{
		return doctorReportRepository.save(doctorReport);
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
	
	public List<DoctorReport> getAllRep(String keyword)
	{
		if(keyword!=null)
		{
			return doctorReportRepository.allfull(keyword);
		}
		else
		{
			return doctorReportRepository.findAll();
		}
	}

	public void deleteRep(Long id) 
	{
		doctorReportRepository.deleteById(id);
		
	}

	public DoctorReport getParticularRep(Long id)
	{
		Optional<DoctorReport> findById = doctorReportRepository.findById(id);
		return findById.get();
	}

	public void addRep(DoctorReport doctorReport)
	{
		doctorReportRepository.save(doctorReport);
		
	}

	public List<DoctorReport> findByDateBetween(String startDate, String endDate) 
	{
		if(startDate!=null && endDate!=null)
		{
			return doctorReportRepository.findStart(startDate, endDate);
		}
		else
		{
			return doctorReportRepository.findAll();
		}
	}

}
