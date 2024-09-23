package com.example.school_test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school_test.Dto.QuestionDto;
import com.example.school_test.Service.QuestionService;
import com.example.school_test.entity.Questions;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	  @PostMapping
	  public Questions createQuestion(@RequestBody Questions questions) {
		  return questionService.createQuestion(questions);
	  }
	  
	  @GetMapping("/{id}")
	  public Questions getQuestion(@PathVariable Long id) {
		  return questionService.getQuestion(id);
	  }
	  
	  @PutMapping("/{id}")
	  public String updateQuestion(@PathVariable Long id,@RequestBody Questions questions) {
		  return questionService.updateQuestion(id, questions);
	  }
	  
	  @DeleteMapping("/{id}")
	  public String deleteQuestion(@PathVariable Long id) {
		  return questionService.deleteQuestion(id);
	  }
	  
	  @GetMapping("/all")
	  public List<Questions> getallQuestions(){
		  return questionService.getAllQuestions();
	  }
	  
	  @GetMapping
	  public List<QuestionDto> getAllQuestionDTOs(){
		  return questionService.getAllQuestionDTOs();
	  }
	  
	  @GetMapping("/dto/{id}")
	  public QuestionDto getOneQuestionDTOS(@PathVariable Long id) {
		  return questionService.getOneQuestionDTOS(id);
	
	  }
	  
	  
}
