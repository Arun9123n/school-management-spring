package com.example.school_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school_test.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long>{

}
