package com.mss.ecert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mss.ecert.domain.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, String> {

//	 @Query(value = "SELECT * FROM certification WHERE certificationname = :certificationname", nativeQuery = true)
//	 List<Certification> findCertificationIdByName(@Param("certificationname") String certificationname);
	
	@Query(value = "SELECT * FROM certification WHERE certificationid = :certificationid", nativeQuery = true)
	List<Certification> findCertificationById(@Param("certificationid") String certificationId);
}
