package com.example.school_test.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.school_test.entity.School;
import com.example.school_test.exception.UserNotFoundException;
import com.example.school_test.repository.SchoolRepository;
import com.example.school_test.repository.StudentRepository;
import com.example.school_test.repository.TeachersRepository;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeachersRepository teachersRepository;
	
	public School createSchool(School school) {
		return schoolRepository.save(school);
	}
	
    public School getSchool(Long id) {
        return schoolRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("School not found by id " + id));
    }

    public String updateSchool(Long id, School school) {
        schoolRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("School not found by id " + id));
        school.setId(id);
         schoolRepository.save(school);
         return "Updated Successfully!";
    }

    public String deleteSchool(Long id) {
        School school = schoolRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("School not found by id " + id));
        this.schoolRepository.delete(school);
        return "Deleted school successfully";
    }

    
    public List<School> getallSchool() {
    	return schoolRepository.findAll();   
    }
    
    public List<Object> getAllStudentandTeachersCountBySchoolId(Long id){
        List<Object> result = new LinkedList<>();
        result.add(studentRepository.findBySchoolId(id));
        result.add(teachersRepository.findBySchoolId(id));
        return result;
    }
    
    public Map<String, Long> getStudentCountById(Long id){
        Long studentCount = studentRepository.countBySchoolId(id); 
        Map<String, Long> response = new HashMap<>();
        response.put("Total Student Count", studentCount);
        return response;
    }

    public Map<String, Long> getTeachersCountById(Long id){
        Long teacherCount = teachersRepository.countBySchoolId(id);
        Map<String, Long> response = new HashMap<>();
        response.put("Total Teachers Count", teacherCount);
        return response;
    }

	public Page<School> getSchoolByPage(int pageIndex, int pageSize, String field) {
		   Sort sort=Sort.by(Sort.Direction.ASC,field);
	       Pageable pageReq=PageRequest.of(pageIndex, pageSize, sort);
	       return schoolRepository.findAll(pageReq);
	}

}
