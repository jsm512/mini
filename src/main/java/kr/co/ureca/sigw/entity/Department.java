package kr.co.ureca.sigw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
@ToString
public class Department {

    @Id
    @Column(name = "idx")
    private int departmentId;

    @Column(name = "name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
