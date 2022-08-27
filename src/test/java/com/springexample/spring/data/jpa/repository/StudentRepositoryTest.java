package com.springexample.spring.data.jpa.repository;

import com.springexample.spring.data.jpa.enitity.Guardian;
import com.springexample.spring.data.jpa.enitity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().
                emailId("harsha@gmailcom")
                .firstName("harsha")
                .lastName("N")
               /* .guardianName("Narayanan")
                .guardianEmail("narayan@gmail.com")
                .guardianMobile("8787878787")*/
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Ritesh")
                .email("ritesh@gmail.com")
                .mobile("897675456").build();
        Student student = Student.builder()
                .firstName("Ritu")
                .lastName("Siva")
                .emailId("ritu@gmail.com")
                .guardian(guardian).build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Ritesh");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnEmailid(){
        List<Student> students = studentRepository.findByEmailAddress("harsha@gmailcom");
        System.out.println("students = " + students);
    }

    @Test
    public void updateStudentNameBasedOnEmailid(){
        studentRepository.updateStudentNameByEmailId("Shivani","harsha@gmailcom");
    }
}