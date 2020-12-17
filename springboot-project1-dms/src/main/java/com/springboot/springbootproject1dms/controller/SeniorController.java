package com.springboot.springbootproject1dms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.springbootproject1dms.exception.ResourceNotFoundException;
import com.springboot.springbootproject1dms.model.Senior;
import com.springboot.springbootproject1dms.repository.SeniorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class SeniorController {
	@Autowired
	private SeniorRepository seniorRepository;
	
	@GetMapping("/seniors")
	public List<Senior> getAllSeniors(){
		return seniorRepository.findAll();
	}
	
	@GetMapping("/all")
	public String welcome(){
		return "welcome";
	}
	
	@GetMapping("/seniors/{id}")
    public ResponseEntity<Senior> getSeniorById(@PathVariable(value = "id") Long seniorId)
        throws ResourceNotFoundException {
        Senior senior = seniorRepository.findById(seniorId)
          .orElseThrow(() -> new ResourceNotFoundException("Senior not found for this id :: " + seniorId));
        return ResponseEntity.ok().body(senior);
    }
    
    @PostMapping("/seniors")
    public Senior createSenior(@Validated @RequestBody Senior senior) {
        return seniorRepository.save(senior);
    }

    @PutMapping("/seniors/{id}")
    public ResponseEntity<Senior> updateSenior(@PathVariable(value = "id") Long seniorId,
         @Validated @RequestBody Senior seniorDetails) throws ResourceNotFoundException {
        Senior senior = seniorRepository.findById(seniorId)
        .orElseThrow(() -> new ResourceNotFoundException("Senior not found for this id :: " + seniorId));

        senior.setEmailId(seniorDetails.getEmailId());
        senior.setLastName(seniorDetails.getLastName());
        senior.setFirstName(seniorDetails.getFirstName());
        senior.setFoodConstraint(seniorDetails.getFoodConstraint());
        senior.setAge(seniorDetails.getAge());
        final Senior updatedSenior = seniorRepository.save(senior);
        return ResponseEntity.ok(updatedSenior);
    }
    
    @DeleteMapping("/seniors/{id}")
    public Map<String, Boolean> deleteSenior(@PathVariable(value = "id") Long seniorId)
         throws ResourceNotFoundException {
        Senior senior = seniorRepository.findById(seniorId)
       .orElseThrow(() -> new ResourceNotFoundException("Senior not found for this id :: " + seniorId));

        seniorRepository.delete(senior);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
