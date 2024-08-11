package kr.co.ureca.sigw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "appoval")
@Getter
@Setter
@ToString
public class Approval {

    @Id
    @Column(name = "idx")
    private Long approvalId;

    @Column(name = "status")
    private String approvalStatus;

    @Column(name = "date")
    private LocalDate approvalDate;

    @Column(name = "approver")
    private String approverName;

    @ManyToOne
    @JoinColumn(name = "request_idx",nullable = false)
    private RequestVacation requestId;

    @ManyToOne
    @JoinColumn(name = "employee_idx", nullable = false)
    private Employee empId;
}
