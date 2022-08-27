package com.springexample.spring.data.jpa.enitity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name="couserMaterialId_sequence",
            sequenceName = "couserMaterialId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "couserMaterialId_sequence")
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name="course_id",
            referencedColumnName = "courseId"

    )
    private Course course;

}
