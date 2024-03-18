package com.assignment.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.assignment.model.DataModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssignmentService {
	Flux<DataModel> getAllData();
	
	
	Mono<DataModel> saveData(DataModel data);
	
	Mono<ResponseEntity<DataModel>> updateData(long id,DataModel product);
	
	Mono<ResponseEntity<Void>> deleteData(long id);
}
