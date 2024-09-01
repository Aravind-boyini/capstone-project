package com.controller;
import com.exceptions.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Academy;
import com.repository.AcademyRepository;
import com.service.AcademyService;

@RestController
@Validated
@RequestMapping("/academies")
public class AcademyController {
	@Autowired
    AcademyService academyService;
    
    @Autowired
    AcademyRepository academyRepos;

    private static final Logger logger = LoggerFactory.getLogger(AcademyController.class);
   
    @GetMapping("/sport/{sportType}")
	public ResponseEntity<List<Academy>> showAcademiesBySportType(@PathVariable("sportType")  String sportType) throws CustomException {
    	logger.info("Academies by sportType called:");
    	List<Academy> academy=academyService.listAcademiesBySportType(sportType);
		if(academy==null || academy.isEmpty() ) {
			logger.warn("No records found for sport type: {}", sportType);
			throw new CustomException("No records found for that sport:"+sportType);
		}
		 logger.info("Returning response with status 200 OK for sport type: {}", sportType);
		return new ResponseEntity<>(academy,HttpStatus.OK);		
    }
    
    @GetMapping("/searchId/{academyId}")
	public ResponseEntity<Academy> showAcademiesByAcademyId(@PathVariable("academyId")  Integer academyId) throws CustomException {
    	logger.info("Academies by Id called:");
    	Academy academy=academyService.listAcademiesByAcademyId(academyId);
		if(academy==null ) {
			logger.warn("No records found for academyId: {}", academyId);
			throw new CustomException("No records found for that academyId:"+academyId);
		}
	   logger.info("Returning response with status 200 OK for academyId: {}",academyId);
		return new ResponseEntity<>(academy,HttpStatus.OK);		
    }
    

}
