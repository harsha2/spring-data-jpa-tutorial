package com.springexample.spring.data.jpa.repository;

import com.springexample.spring.data.jpa.enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByGuardianName(String guardianName);

    @Query("select s from Student s where s.emailId=?1")
    public List<Student> findByEmailAddress(String emailId);


    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String firstName, String emailId);
}
