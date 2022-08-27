package com.springexample.spring.data.jpa.repository;

import com.springexample.spring.data.jpa.enitity.Course;
import com.springexample.spring.data.jpa.enitity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course1 = Course.builder()
                .title("Spring Boot")
                .credit(3)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course1)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourserMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("courseMaterialList = " + courseMaterialList);
    }
}