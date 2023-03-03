package com.mss.ecert.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mss.ecert.domain.Certification;
import com.mss.ecert.domain.QuestionPaper;
import com.mss.ecert.repository.QuestionPaperRepository;
import com.mss.ecert.repository.UserRepository;
import com.mss.ecert.service.CertificationService;

@RestController
public class CertificationController {

	@Autowired
	CertificationService certificationService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	QuestionPaperRepository questionPaperRepository;
	
	@PostMapping("/manager/createCertification/{hubbleId}")
	public Certification createCertification(@RequestBody Certification data, @PathVariable int hubbleId) {
		Certification certificateData = initCertification(data, hubbleId);
		return certificationService.createCertification(certificateData);
	}
	
	@GetMapping("/getAllCertificates")
	public List<Certification> getAllCertificates() {
		return certificationService.getAllCertificates();
	}
	
	
	@GetMapping("/getAllCertificatesById/{certificationid}")
	public List<Certification> getCertificationById(@PathVariable String certificationid) {
		System.out.println("welcome");
		return certificationService.getCertificationById(certificationid);
	}
	
	

	@PostMapping("/manager/createQuestions/{hubbleId}/{certificationId}")
	public List<QuestionPaper> createQuestions(@RequestBody List<QuestionPaper> data, @PathVariable int hubbleId,@PathVariable String certificationId) {
	    List<QuestionPaper> questionPapers = new ArrayList<>();
	    for (QuestionPaper question : data) {
	        QuestionPaper questionPaper = initQuestionPaper(question, hubbleId, certificationId);
	        questionPapers.add(certificationService.createQuestions(questionPaper));
	    }
	    return questionPapers;
	}

	private QuestionPaper initQuestionPaper(QuestionPaper data, int hubbleId, String certificationId) {
	    QuestionPaper details = new QuestionPaper();
	    String name = userRepository.findIdByName(hubbleId);
	    details.setQuestion(data.getQuestion());
	    details.setChoice01(data.getChoice01());
	    details.setChoice2(data.getChoice2());
	    details.setChoice3(data.getChoice3());
	    details.setChoice4(data.getChoice4());
	    details.setMarkedOption(data.getMarkedOption());
	    details.setCreatedBy(name);
	    details.setLastModifiedBy(name);
	    details.setCreationDate(java.time.LocalDate.now());
	    details.setLastModifiedDate(java.time.LocalDate.now());

//	    String certificateId = questionPaperRepository.findIdByName(certificationId);
	    Certification certification = new Certification();
	    certification.setCertificationid(certificationId);
	    details.setCertification(certification);
	    return details;
	}
	private Certification initCertification(Certification data, int hubbleId) {
		Certification details = new Certification();
		String name;
		name = userRepository.findIdByName(hubbleId);
		
		//details.setCertificationid(UUID.randomUUID().toString());
		details.setCertificationid(data.getCertificationid());
		details.setCertificationname(data.getCertificationname());
		details.setCertificationdescription(data.getCertificationdescription());
		details.setCertificationnotice(data.getCertificationnotice());
		details.setCertificationtime(data.getCertificationtime());
		details.setAssigned(data.getAssigned());
		details.setQuiztaken(data.getQuiztaken());
		details.setCreationDate(java.time.LocalDate.now());
		details.setCreatedBy(name);
		details.setLastModifiedBy(name);
		details.setLastModifiedDate(java.time.LocalDate.now());
		details.setTags(data.getTags());
		details.setStatus(data.getStatus());
		return details;
	}

}
