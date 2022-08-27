package com.springexample.spring.data.jpa.repository;

import com.springexample.spring.data.jpa.enitity.Course;
import com.springexample.spring.data.jpa.enitity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){

        Course OScourse = Course.builder()
                .title("OScourse")
                .credit(4)
                .build();
        Course DBcourse = Course.builder()
                .title("DBcourse")
                .credit(4)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Sita")
                .lastName("Ram")
             //   .courses(List.of(DBcourse,OScourse))
                .build();
        teacherRepository.save(teacher);
    }
}