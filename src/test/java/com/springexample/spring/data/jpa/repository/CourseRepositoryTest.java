package com.springexample.spring.data.jpa.repository;

import com.springexample.spring.data.jpa.enitity.Course;
import com.springexample.spring.data.jpa.enitity.Student;
import com.springexample.spring.data.jpa.enitity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Deepa")
                .lastName("Rajan")
                .build();
        Course course = Course.builder()
                .title("Science")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void finalAllPagination(){
        Pageable firstPageWithThreeRecords =
                (Pageable) PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                (Pageable) PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("courses = " + courses);
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2,Sort.by("title").descending()
                        .and(Sort.by("credit").descending()));

        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);
        List<Course> courses =
                courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Radha")
                .lastName("Krishna")
                .build();
        Student student = Student.builder()
                .firstName("Titu")
                .lastName("Mol")
                .emailId("titu@gmail.com")
                .build();
        Course course = Course.builder()
                .title("Geography")
                .credit(5)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}