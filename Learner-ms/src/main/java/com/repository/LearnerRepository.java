package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.model.Learner;

public interface LearnerRepository extends CrudRepository<Learner, Integer> {
    
	boolean existsByEmail(String email);
	Learner findByEmail(String email);
}
