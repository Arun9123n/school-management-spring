package com.example.school_test.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school_test.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long>{

}
