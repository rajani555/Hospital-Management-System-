package com.vgnit.medical.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.vgnit.medical.entity.DoctorReport;

public interface DoctorReportRepository extends JpaRepository<DoctorReport, Long>
{
	
	@Query("SELECT doctorReport FROM DoctorReport doctorReport WHERE doctorReport.dName LIKE %?1%"
		+ "OR doctorReport.description LIKE %?1%")
	List<DoctorReport> allfull(String keyword);

	
	@Query("SELECT dr FROM DoctorReport dr WHERE STR_TO_DATE(dr.date, '%Y-%m-%d') BETWEEN :startDate AND :endDate")
	List<DoctorReport> findStart(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
}
