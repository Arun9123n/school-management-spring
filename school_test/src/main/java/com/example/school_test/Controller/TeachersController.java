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


import com.example.school_test.Service.TeacherService;
import com.example.school_test.entity.Teachers;

@RestController
@RequestMapping("/api/teacher")
public class TeachersController {

	@Autowired
	private TeacherService teacherService;
	
	@PostMapping
	public Teachers createTeacher(@RequestBody Teachers teachers) {
		return teacherService.createTeacher(teachers);
	}
	
	@GetMapping("/{id}")
	public Teachers getTeacher(@PathVariable Long id) {
		return teacherService.getTeacher(id);
	}
	
	@PutMapping("/{id}")
	public String updateTeacher(@PathVariable Long id , @RequestBody Teachers teachers) {
		return teacherService.updateTeacher(id, teachers);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		return teacherService.deleteTeacher(id);
	}
    
	@GetMapping
	public List<Teachers> getallTeachers(){
		return teacherService.getAllTeachers();
	}
	
    @GetMapping("/mark/{id}")
	public String studentMark(@PathVariable Long id) {
		return teacherService.studentMarkMessage(id);
   }
    @GetMapping("/allstudent/marks")
	public String allstudentsmarks(){
	   return teacherService.allStudentMarkMessage();
	}

   @GetMapping("/users")
   public Page<Teachers> getTeachers(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam String field){
	   return teacherService.getTeachersByPage(pageIndex, pageSize, field);
   }
}
