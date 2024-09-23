package com.example.school_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.school_test.entity.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers, Long> {
 
	   List<Teachers> findBySchoolId(Long id);
	   Long countBySchoolId(Long id);
}
