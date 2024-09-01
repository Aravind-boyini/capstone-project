package com.service;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.ms.AcademyMs;
//import com.client.AcademyClient;
import com.model.Academy;
import com.learnerexception.CustomException;
//import com.exception.CustomException;
import com.model.Enrollment;
import com.model.Learner;
import com.repository.EnrollmentRepository;
import com.repository.LearnerRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
//import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerService {

    @Autowired
    LearnerRepository learnerRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;
    
    @Autowired
    RestTemplate restTemplate;

    
    @Autowired
    AcademyMs academyMs;
    
   
    String baseUrl = "http://academyms/academies/searchId";

    public Learner registerLearner(Learner learner)throws CustomException {
    	if (learnerRepository.existsByEmail(learner.getEmail())) {
            throw new CustomException("Learner with email " + learner.getEmail() + " already exists.");
        }  
    	Learner learner1=learnerRepository.save(learner);
    	
        return learner1;
    }

    public boolean authenticateLearner(String email, String password) {
        Learner learner = learnerRepository.findByEmail(email);
        return learner != null && learner.getPassword().equals(password);
    }

    public List<Academy> getAcademies(String sportType) {
        return academyMs.getAcademiesBySportType(sportType);
    }
    
    public Academy getAcademyById(int id) {
		 //System.out.println(id);
			String url = baseUrl + "/" + id;
			//System.out.println(url);
			return restTemplate.getForObject(url, Academy.class);
		}
     

    
    public Enrollment enrollInAcademy(int learnerId, int academyId) {
        // Fetch the learner from the database
        Learner learner = learnerRepository.findById(learnerId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid learner ID: " + learnerId));
        

        // Create a new enrollment
        Enrollment enrollment = new Enrollment();
        enrollment.setLearner(learner);
        enrollment.setAcademyId(academyId);
        enrollment.setStatus("Enrolled");
     // Set the enrollment date to the current date and time
        enrollment.setEnrollmentDate(LocalDateTime.now());
        // Save the enrollment to the database
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByLearnerId(int learnerId) {
        // Find the learner by ID
        Learner learner = learnerRepository.findById(learnerId)
                .orElseThrow(() -> new RuntimeException("No enrollments found with LearnerId:"+learnerId));
        
        // Find enrollments by learnerId
        return enrollmentRepository.findByLearnerLearnerId(learnerId);
    }
}



