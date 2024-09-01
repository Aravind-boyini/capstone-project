package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Academy;
import com.repository.AcademyRepository;

@Service
public class AcademyService {
	
	@Autowired
    AcademyRepository academyRepos;

	
	
	public List<Academy> listAcademiesBySportType(String sportType){
		return academyRepos.findAllBySportType(sportType);
	}
	public Academy listAcademiesByAcademyId(Integer academyId) {
		return academyRepos.findAllByAcademyId(academyId);
	}

}
