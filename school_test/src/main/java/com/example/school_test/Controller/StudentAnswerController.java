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

import com.example.school_test.Service.StudentAnswerService;
import com.example.school_test.entity.StudentAnswer;

@RestController
@RequestMapping("/api/student/answer")
public class StudentAnswerController {

	@Autowired
    private StudentAnswerService studentAnswerService;
	
	  @PostMapping
	  public StudentAnswer createStudent_answer(@RequestBody StudentAnswer student_answer) {
		  return studentAnswerService.createStudentAnswer(student_answer);
	  }
	  
	  @GetMapping("/{id}")
	  public StudentAnswer getStuAnswer(@PathVariable Long id) {
		  return studentAnswerService.getStudentAnswer(id);
	  }
	  
	  @PutMapping("/{id}")
	  public String updateStudent_answer(@PathVariable Long id,@RequestBody StudentAnswer student_answer) {
		  return studentAnswerService.updateStudentAnswer(id, student_answer);
	  }
	  
	  @DeleteMapping("/{id}")
	  public String deleteStudentAnswer(@PathVariable Long id) {
		  return studentAnswerService.deleteStudentAnswer(id);
	  }
	  
	  @GetMapping
	  public List<StudentAnswer> getallQuestions(){
		  return studentAnswerService.getallStudentAnswer();
	  }
	  
}
