package com.fieclweb.jpa.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@AllArgsConstructor
@Entity
//@Table(name = "AUTHOR_TBL")
public class Author {

    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
////            strategy = GenerationType.TABLE,
//            generator = "author_sequence" // To check the diff between this and 'author_seq' (which is automatically generated)
////            generator = "author_id_gen"
//    )
//    @SequenceGenerator(
//            name = "author_sequence", // This should be the same as the 'generator' in @GeneratedValue
//            sequenceName = "author_sequence", // IMPORTANT: What's the diff bet this and the 'name' above?
//            allocationSize = 1
//    )
////    @TableGenerator(
////            name = "author_id_gen",
////            table = "id_generator", // You get to choose this name (arbitrarily set)
////            pkColumnName = "id_name",
////            valueColumnName = "id_value",
////            allocationSize = 1
////    )
    @GeneratedValue
    private Integer id; // We're using 'Integer', instead of 'int' since the default value of 'Integer' is null while the default value of 'int' is 0

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;

    @Column(
            updatable = false,
            nullable = true
    )
    private LocalDateTime createdAt;

    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
