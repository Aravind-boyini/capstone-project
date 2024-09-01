package com.ms;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.model.Academy;

@Component
public class AcademyMs {

    @Autowired
    private RestTemplate restTemplate;
  /*
    public List<Academy> getAcademyById(int academyId) {
        ResponseEntity<Academy[]> response = restTemplate.getForEntity(
            "http://academyms/academies/searchId/" + academyId,
            Academy[].class
        );
        return Arrays.asList(response.getBody());
    }
  */
    public List<Academy> getAcademiesBySportType(String sportType) {
        ResponseEntity<Academy[]> response = restTemplate.getForEntity(
            "http://academyms/academies/sport/" + sportType,
            Academy[].class
        );
        return Arrays.asList(response.getBody());
    }
}

