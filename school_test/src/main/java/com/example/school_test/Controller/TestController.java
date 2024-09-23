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


import com.example.school_test.Service.TestService;
import com.example.school_test.entity.Test;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	  @PostMapping
	  public Test createTest(@RequestBody Test test) {
		  return testService.createTest(test);
	  }
	  
	  @GetMapping("/{id}")
	  public Test getTest(@PathVariable Long id) {
		  return testService.getTest(id);
	  }
	  
	  @PutMapping("/{id}")
	  public String updateTest(@PathVariable Long id,@RequestBody Test test) {
		  return testService.updateTest(id, test);
	  }
	  
	  @DeleteMapping("/{id}")
	  public String deleteQuestion(@PathVariable Long id) {
		  return testService.deleteTest(id);
	  }
	  
	  @GetMapping
	    public List<Test> getallQuestions(){
		  return testService.getAllTest();
	  }
	
	
}
