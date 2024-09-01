package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EnrollmentRequest;
import com.learnerexception.CustomException;
//import com.exception.CustomException;
import com.model.Academy;
import com.model.Enrollment;
import com.model.Learner;
import com.service.LearnerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learners")
public class LearnerController {

	@Autowired
    LearnerService learnerService;
	
	private static final Logger logger = LoggerFactory.getLogger(LearnerController.class);

    // Registration: POST /learners/
    @PostMapping("/")
    public ResponseEntity<Learner> registerLearner(@Valid@RequestBody Learner learner) throws CustomException{
    	logger.info("Register now:");
        Learner registeredLearner = learnerService.registerLearner(learner);
        return new ResponseEntity<>(registeredLearner, HttpStatus.CREATED);
    }

    // Login: POST /learners/login
    @PostMapping("/login")
    public ResponseEntity<String> loginLearner(@RequestBody Learner learner) {
    	logger.info("loggin learner called");
        boolean isAuthenticated = learnerService.authenticateLearner(learner.getEmail(), learner.getPassword());
        if (isAuthenticated) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
    // Search Academies: GET /learners/search/{sporttype}
    @GetMapping("/search/{sporttype}")
    public ResponseEntity<List<Academy>> searchAcademies(@PathVariable("sporttype") String sportType) throws CustomException{
    	logger.info("Academies by sportType called:");
    	List<Academy> academies = learnerService.getAcademies(sportType);
        if (academies == null || academies.isEmpty()) {
            throw new CustomException("No records found for the sport: " + sportType);
        }
        
        return new ResponseEntity<>(academies, HttpStatus.OK);
        
    }
    
    
    @GetMapping("/academy/{academyId}")
	  public ResponseEntity<?> searchAcademiesbyId(@PathVariable("academyId") int academyId) throws CustomException {
    	
    	logger.info("Academies by Id called:");
	        Academy academy = learnerService.getAcademyById(academyId);
	       
	        if (academy == null ) {
	            throw new CustomException("No records found for the AcademyId: " + academyId);
	        }
	        
	        return new ResponseEntity<>(academy, HttpStatus.OK);
	    }
   
    @PostMapping("/enroll")
    public ResponseEntity<Enrollment> enrollInAcademy(@Valid@RequestBody EnrollmentRequest request) {
    	logger.info("Enroll now");
        Enrollment enrollment = learnerService.enrollInAcademy(request.getLearnerId(), request.getAcademyId());
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }

    
    
    // View Enrollments: GET /learners/enrollments/{learnerId}
    @GetMapping("/enrollments/{learnerId}")
    public ResponseEntity<List<Enrollment>> viewEnrollments(@PathVariable("learnerId") int learnerId) throws CustomException{
    	logger.info("Enrollments by learnerId called:");
    	List<Enrollment> enrollments = learnerService.getEnrollmentsByLearnerId(learnerId);
        if (enrollments == null || enrollments.isEmpty()) {
            throw new CustomException("No enrollments found for the learnerId: " + learnerId);
        }

        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

}
