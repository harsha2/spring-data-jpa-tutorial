package com.springexample.spring.data.jpa.repository;

import com.springexample.spring.data.jpa.enitity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
