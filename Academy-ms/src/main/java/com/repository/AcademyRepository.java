package com.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.model.Academy;

@Repository
public interface AcademyRepository extends CrudRepository<Academy, Integer> {
	
    public List<Academy> findAllBySportType(String sportType);
	
	public Academy findAllByAcademyId(Integer academyId);
	
	

	
}
