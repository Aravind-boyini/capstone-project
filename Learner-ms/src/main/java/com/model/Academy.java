package com.model;

import jakarta.persistence.Column;


//import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Academy {
   
    private int academyId;
    
    private String academyName;
   
    private String email;
  
    private String location;
    
    private String sportType;
    
    private String description;

	public int getAcademyId() {
		return academyId;
	}

	public void setAcademyId(int academyId) {
		this.academyId = academyId;
	}

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Academy(String academyName, String email, String location, String sportType, String description) {
		super();
		this.academyName = academyName;
		this.email = email;
		this.location = location;
		this.sportType = sportType;
		this.description = description;
	}

	public Academy() {
		super();
	}

	@Override
	public String toString() {
		return "Academy [academyId=" + academyId + ", academyName=" + academyName + ", email=" + email + ", location="
				+ location + ", sportType=" + sportType + ", description=" + description + "]";
	}

	
    
	
    
}
