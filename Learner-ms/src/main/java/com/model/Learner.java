package com.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="learner")
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int learnerId;
    
    @OneToMany(mappedBy = "learner")
    @JsonIgnore
    private List<Enrollment> enrollments;

    
    @Column(name="user_name")
    @NotNull(message = "Name cannot be null")
    private String name;
    
    @Column(name="email")
    @NotNull(message = "Email cannot be null")
    private String email;
    
    @Column(name="gender")
    @NotNull(message = "Gender cannot be null")
    private String gender;
    
    @Column(name="birthdate")
    @NotNull(message = "Birthdate cannot be null")
    private Date birthDate;
    
    @Column(name="user_password")
    @NotNull(message = "Password cannot be null")
    private String password;
    
    

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public int getLearnerId() {
		return learnerId;
	}

	public void setLearnerId(int learnerId) {
		this.learnerId = learnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Learner(String name, String email, String gender, Date birthDate, String password) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.birthDate = birthDate;
		this.password = password;
	}

	public Learner() {
		super();
	}

	@Override
	public String toString() {
		return "Learner [learnerId=" + learnerId + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", birthDate=" + birthDate + ", password=" + password + "]";
	}

    
    // Getters and setters
}
