package com.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Document(collection = "assignmentData")
@Data
public class DataModel {
	
	//@BsonProperty("_id")  
	@Id
	private long _id;
	
	//@Id
	//private String id;
	
	//@NotNull(message = "Image can not be null")
	@NotEmpty(message = "need image")
	private String name;
	
	///@NotNull(message = "Image can not be null")
	private String nrc;
	
	private String birthday;
	
	private String interest;
	
	//@NotNull(message = "Image can not be null")
	private Long phone;
	
	//@NotNull(message = "Image can not be null")
	private String email;
	
	//@NotNull(message = "Image can not be null")
	private String township;
	
	private String address;

}
