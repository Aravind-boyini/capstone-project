package com.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="enrollment_id")
    private int enrollmentId;
  /*  
    @Column(name="learner_id")
    private int learnerId;
    */
    
    @ManyToOne
    @JoinColumn(name = "learner_id", nullable = false)
    @NotNull(message = "Learner must not be null")
    private Learner learner;
    
    @Column(name="academy_id")
    @NotNull(message = "Academy ID must not be null")
    private int academyId;
    /*
    @Column(name="enrollment_date")
    @NotNull(message = "Enrollment date must not be null")
    private Timestamp enrollmentDate;  */
    
    @Column(name = "enrollment_date", updatable = false)
    //@NotNull(message = "Enrollment date must not be null")
    private LocalDateTime enrollmentDate;
    
    @Column(name="enroll_status")
   // @NotNull(message = "Status must not be null")
    private String status;

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Learner getLearner() {
		return learner;
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

	public int getAcademyId() {
		return academyId;
	}

	public void setAcademyId(int academyId) {
		this.academyId = academyId;
	}

	public LocalDateTime getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Enrollment(Learner learner, int academyId,LocalDateTime enrollmentDate, String status) {
		super();
		this.learner = learner;
		this.academyId = academyId;
		this.enrollmentDate = enrollmentDate;
		this.status = status;
	}

	public Enrollment() {
		super();
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", learner=" + learner + ", academyId=" + academyId
				+ ", enrollmentDate=" + enrollmentDate + ", status=" + status + "]";
	}

	
    
}

