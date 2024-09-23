package com.example.school_test.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.school_test.entity.Student;
import com.example.school_test.exception.UserNotFoundException;
import com.example.school_test.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
     public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudent(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("Student not found by id "+ id));
   }
	
	public String updateStudent(Long id,Student student) {
		studentRepository.findById(id)
		.orElseThrow(()->new UserNotFoundException("Student not found by id "+id));
		student.setId(id);
	    studentRepository.save(student);
	    return "Updated Succesfully!";
	}
	
	 public String deleteStudent(Long id) {
	   Student student = studentRepository.findById(id)
	    .orElseThrow(()->new UserNotFoundException("Student not found by id "+id));
	   this.studentRepository.delete(student);
	    return "Deleted Successfully!";
	    
	 }
	 
	 public List<Student> getallStudent(){
		 return studentRepository.findAll();
	 }
	  
	 public Page<Student> getStudentByPage(int pageIndex,int pageSize,String field){
		 Sort sort = Sort.by(Sort.Direction.ASC,field);
		 Pageable pageReq = PageRequest.of(pageIndex, pageSize, sort);
		 return studentRepository.findAll(pageReq);
	 }
	
}
