package com.example.school_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.school_test.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
    List<Student> findBySchoolId(Long id);
    Long countBySchoolId(Long id);
}
