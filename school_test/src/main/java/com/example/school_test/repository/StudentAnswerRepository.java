package com.example.school_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.school_test.entity.StudentAnswer;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long>{

     List<StudentAnswer> findAllByStudentId(Long studentId);
}
