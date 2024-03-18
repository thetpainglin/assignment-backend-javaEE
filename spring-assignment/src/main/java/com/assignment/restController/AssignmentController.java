package com.assignment.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.DataModel;
import com.assignment.service.AssignmentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/assignment")
@CrossOrigin
@Slf4j
public class AssignmentController {
	
	@Autowired
	AssignmentService assignmentService;
	
	@GetMapping
	public Flux<DataModel> getAllData(){
		return assignmentService.getAllData();
	}
	
	@PostMapping
	public Mono<DataModel> saveData(@RequestBody @Valid DataModel product){
		log.info("product saving "+product);
		return assignmentService.saveData(product);
	}
	
	@PutMapping("/{id}")
	public Mono<ResponseEntity<DataModel>> updateData(@PathVariable(value="id") long id, 
			@Valid @RequestBody DataModel product){
		
		return assignmentService.updateData(id, product);
	}
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> deleteData(@PathVariable(value="id") long id){
		return assignmentService.deleteData(id);
	}

}
