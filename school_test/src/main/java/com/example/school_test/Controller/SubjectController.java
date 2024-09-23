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


import com.example.school_test.Service.SubjectService;
import com.example.school_test.entity.Subject;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	  @PostMapping
	  public Subject createSubject(@RequestBody Subject subject) {
		  return subjectService.createSubject(subject);
	  }
	  
	  @GetMapping("/{id}")
	  public Subject getSubject(@PathVariable Long id) {
		  return subjectService.getSubject(id);
	  }
	  
	  @PutMapping("/{id}")
	  public String updateSubject(@PathVariable Long id,@RequestBody Subject subject) {
		  return subjectService.updateSubject(id, subject);
	  }
	  
	  @DeleteMapping("/{id}")
	  public String deleteSubject(@PathVariable Long id) {
		  return subjectService.deleteSubject(id);
	  }
	  
	  @GetMapping
	  public List<Subject> getAllSubjects(){
		  return subjectService.getAllSubjects();
	  }
}
