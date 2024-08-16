package kr.co.ureca.sigw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long empId;

    @Column(name = "name")
    private String empName;

    @Column(name = "role")
    private String empRole;

    @Column(name = "hiredate")
    private LocalDateTime empHiredate;

    @Column(name = "remained_vacation")
    private int remainingVacation;

    @ManyToOne
    @JoinColumn(name = "department_idx", nullable = false)
    private Department department;

    @Column(name = "password")
    private String userPassword;

    @OneToMany(mappedBy = "employee")
    private List<RequestVacation> requestVacations;

    @OneToMany
    private List<Document> documentsList;
}
