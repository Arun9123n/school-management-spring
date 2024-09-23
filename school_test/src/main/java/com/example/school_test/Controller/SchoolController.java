package com.example.school_test.Controller;

import java.util.List;
import java.util.Map;

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


import com.example.school_test.Service.SchoolService;
import com.example.school_test.entity.School;

@RestController
@RequestMapping("/api/school")

public class SchoolController {
  
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping
	public School createSchool(@RequestBody School school) {
	   return schoolService.createSchool(school);
    }
	
    @GetMapping("/{id}")
    public School getSchool(@PathVariable Long id) {
    	return schoolService.getSchool(id);
    }
    
   @PutMapping("/{id}")
    public String updateSchool(@PathVariable Long id , @RequestBody School school) {
      return schoolService.updateSchool(id, school);
    	
    }
    
   @DeleteMapping("/{id}")
   public String deleteSchool(@PathVariable Long id) {
	  return schoolService.deleteSchool(id);
   }
  
  
	@GetMapping
	public List<School> getallSchool(){
		return schoolService.getallSchool();
	}
	
	
	@GetMapping ("/students/teachers/{id}")
	public List<Object> getallstudentandteacherbyschoolname(@PathVariable Long id){
		return schoolService.getAllStudentandTeachersCountBySchoolId(id);
	}
	
	
	 @GetMapping("/student/count/{id}")
	 public Map<String, Long> getStudentCount(@PathVariable Long id) {
	      return schoolService.getStudentCountById(id);
	    }
	   
	 @GetMapping("/teacher/count/{id}")
	 public Map<String, Long> getTeacherCount(@PathVariable Long id){
	     return schoolService.getTeachersCountById(id);
	 }
	 
	  @GetMapping("/users")
	  public Page<School> getUsers(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam String field){
	        return schoolService.getSchoolByPage(pageIndex, pageSize, field);
	 }
	 
}

