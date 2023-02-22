package com.mss.ecert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.ecert.domain.Certification;
import com.mss.ecert.domain.QuestionPaper;
import com.mss.ecert.repository.CertificationRepository;
import com.mss.ecert.repository.QuestionPaperRepository;

@Service
public class CertificationService {

	@Autowired
	CertificationRepository certificationRepository;
	
	@Autowired
	QuestionPaperRepository questionPaperRepository;
	
	public Certification createCertification(Certification certificateData) {
		return certificationRepository.save(certificateData);
	}

	public List<Certification> getAllCertificates() {
		return certificationRepository.findAll();
	}

	public QuestionPaper createQuestions(QuestionPaper questionPaper) {
		
		return questionPaperRepository.save(questionPaper);
	}

	public List<Certification> getCertificationIdByName(String certificationname) {
		// TODO Auto-generated method stub
		return certificationRepository.findCertificationIdByName(certificationname);
	}

}
