package com.example.school_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school_test.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
