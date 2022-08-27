package com.springexample.spring.data.jpa.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name="teacherId_sequence",
            sequenceName = "teacherId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="teacherId_sequence" )
    private Long teacherId;
    private String firstName;
    private String lastName;

    /*@OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    List<Course> courses;*/

}
