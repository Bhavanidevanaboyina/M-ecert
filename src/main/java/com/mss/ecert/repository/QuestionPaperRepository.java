package com.mss.ecert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mss.ecert.domain.QuestionPaper;


@Repository
public interface QuestionPaperRepository extends JpaRepository<QuestionPaper, Integer>{

	 @Query(value = "SELECT certificationid FROM certification WHERE certificationname =:certificationname", nativeQuery = true)
	    String findIdByName(@Param("certificationname") String certificationname);


}
