package com.example.school_test.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school_test.entity.Subject;
import com.example.school_test.exception.UserNotFoundException;
import com.example.school_test.repository.SubjectRepository;

@Service

public class SubjectService {
   
	@Autowired
	private SubjectRepository subjectRepository;
	public Subject createSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public Subject getSubject(Long id) {
		return subjectRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("Subject not found by id "+id));

	}
	
	public String updateSubject(Long id,Subject subject) {
		subjectRepository.findById(id)
		.orElseThrow(()->new UserNotFoundException("Subject not found by id "+id));
		subject.setId(id);
		subjectRepository.save(subject);
		return "Updated Successfully!";
	}
	
	public String deleteSubject(Long id) {
		Subject subject = subjectRepository.findById(id)
		.orElseThrow(()->new UserNotFoundException("Subject not found bu id "+id));
		this.subjectRepository.delete(subject);
		return "Deleted Successfully!";
	}
	
	public List<Subject> getAllSubjects(){
		return subjectRepository.findAll();
	}
}
