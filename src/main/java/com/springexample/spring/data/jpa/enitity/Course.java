package com.springexample.spring.data.jpa.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "courseId_sequence",
            sequenceName = "courseId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courseId_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name="course_student_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
                 ),
            inverseJoinColumns = @JoinColumn(
                   name = "student_id",
                    referencedColumnName = "studentId"
                )
            )
    List<Student> students;

    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}
