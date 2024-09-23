package com.example.school_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String correctanswer;
	
	@ManyToOne 
	private Teachers teachers;
	
	@ManyToOne
	private Subject subject;
	
	@ManyToOne
	private Test test;
	
}
