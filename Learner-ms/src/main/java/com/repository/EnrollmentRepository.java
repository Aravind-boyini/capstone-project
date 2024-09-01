package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Enrollment;


public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
    List<Enrollment> findByLearnerLearnerId(int learnerId);
}

