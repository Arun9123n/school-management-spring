package com.example.school_test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.school_test.Service.StudentService;
import com.example.school_test.Service.TeacherService;
import com.example.school_test.entity.Student;

@RestController
@RequestMapping("/api/student")

public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	
  @PostMapping
  public Student createStudent(@RequestBody Student student) {
	  return studentService.createStudent(student);
  }
  
  @GetMapping("/{id}")
  public Student getStudent(@PathVariable Long id) {
	  return studentService.getStudent(id);
  }
  
  @PutMapping("/{id}")
  public String updateStudent(@RequestBody Student student,@PathVariable Long id) {
	  return studentService.updateStudent(id, student);
  }
  
  @DeleteMapping("/{id}")
	public String deleteAnswer(@PathVariable Long id) {
		return studentService.deleteStudent(id);
  }
	
  @GetMapping
	public List<Student> getallStudentAnswer(){
		return studentService.getallStudent();
}
  @GetMapping("/mark/{id}")
   public String studentMark(@PathVariable Long id) {
	  return teacherService.studentMarkMessage(id);
  }
  
  @GetMapping("/users")
    public Page<Student> getStudents(@RequestParam int pageIndex,@RequestParam int pageSize,@RequestParam String field){
	  return studentService.getStudentByPage(pageIndex, pageSize, field);
  }
	
}
