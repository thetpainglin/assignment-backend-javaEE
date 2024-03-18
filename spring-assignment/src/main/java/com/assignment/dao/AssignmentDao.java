package com.assignment.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.DataModel;

@Repository
public interface AssignmentDao extends ReactiveMongoRepository<DataModel,Long>{

}
