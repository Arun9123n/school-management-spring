package com.example.school_test.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school_test.entity.Questions;
import com.example.school_test.entity.StudentAnswer;
import com.example.school_test.exception.UserNotFoundException;
import com.example.school_test.repository.StudentAnswerRepository;


@Service
public class StudentAnswerService {

	
	@Autowired
	private StudentAnswerRepository studentAnswerRepository;
	
	  public StudentAnswer createStudentAnswer(StudentAnswer studentAnswer) {
		  return studentAnswerRepository.save(studentAnswer);
	  }
	  
	  public StudentAnswer getStudentAnswer(Long id) {
		return studentAnswerRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("Student answer not found by id "+ id));
	  }
	  
	  public String updateStudentAnswer(Long id , StudentAnswer studentAnswer) {
		 studentAnswerRepository.findById(id)
		 .orElseThrow(()-> new UserNotFoundException("Student answer not found by id "+id));
		 studentAnswer.setId(id);
		 studentAnswerRepository.save(studentAnswer);
		 return "Updted Successfully!";
	  }
	  
	  public String deleteStudentAnswer(Long id) {
		StudentAnswer studentAnswer = studentAnswerRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException("Student answer not found by id "+ id));
		this.studentAnswerRepository.delete(studentAnswer);
		return "Deleted Successfully!";
	  }
	  
	  public List<StudentAnswer> getallStudentAnswer(){
		  return studentAnswerRepository.findAll();
	  }
	  
	   
	  public int studentMark(Long studentId) {
	        List<StudentAnswer> answers = studentAnswerRepository.findAllByStudentId(studentId);
	        int mark = 0;
	        for (StudentAnswer studentAnswer : answers) {
	            Questions questions = studentAnswer.getQuestions();
	            if (questions != null && questions.getCorrectanswer() != null &&
	                studentAnswer.getAnswer() != null) {
	                if (questions.getCorrectanswer().equals(studentAnswer.getAnswer())) {
	                    mark++;
	                }
	            }
	        }
	        return mark;
	    }
	  
	  public String studentMarkMessage(Long studentId) {
		    int mark = studentMark(studentId); 
		    return "Student mark: " + mark;
		}

}
