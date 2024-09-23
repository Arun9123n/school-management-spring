package com.example.school_test.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.school_test.entity.Questions;
import com.example.school_test.entity.Student;
import com.example.school_test.entity.StudentAnswer;
import com.example.school_test.entity.Teachers;
import com.example.school_test.exception.UserNotFoundException;
import com.example.school_test.repository.StudentAnswerRepository;
import com.example.school_test.repository.StudentRepository;
import com.example.school_test.repository.TeachersRepository;

@Service
public class TeacherService {

	@Autowired
	private TeachersRepository teachersRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentAnswerRepository studentAnswerRepository;
	
	public Teachers createTeacher(Teachers teachers) {
		return teachersRepository.save(teachers);
	}
	
	public Teachers getTeacher(Long id) {
		return teachersRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("Teacher not found by id "+id));
	}
	
	public String updateTeacher(Long id,Teachers teachers) {
		teachersRepository.findById(id)
		.orElseThrow(()->new UserNotFoundException("Teacher not found by id "+id));
		teachers.setId(id);
	    teachersRepository.save(teachers);
	    return "Updated Succesfully!";
	}
	
	public String deleteTeacher(Long id) {
		Teachers teachers = teachersRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("Teacher not found by id "+id));
		this.teachersRepository.delete(teachers);
		return "Deleted Successfullt";
	}
	
    public List<Teachers> getAllTeachers(){
	   return teachersRepository.findAll();
   }
   
   
    public int studentMark(Long studentId) {
	        List<StudentAnswer> answers = studentAnswerRepository.findAllByStudentId(studentId);
	        int mark = 0;
	        for (StudentAnswer studentAnswer : answers) {
	            Questions questions = studentAnswer.getQuestions();
	            if (questions != null && questions.getCorrectanswer() != null &&
	                studentAnswer.getAnswer() != null) {
	                if (questions.getCorrectanswer().contains(studentAnswer.getAnswer())) {
	                    mark++;
	                }
	            }
	        }
	        return mark;
	    }

   
   public Map<Long, Integer> allStudentsMarks() {
       List<Student> students = studentRepository.findAll();
       Map<Long, Integer> studentMarks = new HashMap<>();
       for (Student student : students) {
           Long studentId = student.getId();
           int mark = studentMark(studentId);
           studentMarks.put(studentId, mark);
       }
       return studentMarks;
   }
   
   public String studentMarkMessage(Long studentId) {
		    int mark = studentMark(studentId); 
		    return "Student mark: " + mark;
    }
   public String allStudentMarkMessage() {
	   Map<Long, Integer> allMark = allStudentsMarks();
	   return "All Student Marks " + allMark;
   }
   
   public Page<Teachers> getTeachersByPage(int pageIndex ,int pageSize, String field){
	   Sort sort = Sort.by(Sort.Direction.ASC,field);
	   Pageable pagReq = PageRequest.of(pageIndex, pageSize, sort);
	   return teachersRepository.findAll(pagReq);
   }

}
