package com.example.school_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school_test.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Long>{

}
