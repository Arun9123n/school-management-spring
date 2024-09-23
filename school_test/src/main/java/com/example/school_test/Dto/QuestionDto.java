package com.example.school_test.Dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
 
	private Long id;
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
}
