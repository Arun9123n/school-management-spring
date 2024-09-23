package com.example.school_test.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school_test.entity.Test;
import com.example.school_test.exception.UserNotFoundException;
import com.example.school_test.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	public Test createTest(Test test) {
		return testRepository.save(test);
	}
	
	public Test getTest(Long id) {
		return testRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("Test not found by id "+id));
	}
	
	public String updateTest(Long id,Test test) {
	  testRepository.findById(id)
	  .orElseThrow(()->new UserNotFoundException("Test not found by id "+id));
	  test.setId(id);
	  testRepository.save(test);
	  return "Updated Successfully!";
	}
	
	public String deleteTest(Long id) {
		Test test = testRepository.findById(id)
		.orElseThrow(()->new UserNotFoundException("Test not found by id "+id));
		this.testRepository.delete(test);
		return "Deleted Successfully!";
	
	}
	
	public List<Test> getAllTest(){
		return testRepository.findAll();
	}
}
