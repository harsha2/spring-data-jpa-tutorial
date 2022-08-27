package com.springexample.spring.data.jpa.repository;

import com.springexample.spring.data.jpa.enitity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
