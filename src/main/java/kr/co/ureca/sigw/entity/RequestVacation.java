package kr.co.ureca.sigw.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_vacation")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestVacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long requestId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "created_date")
    private LocalDate requestDate;

    @Column(name = "updated_date")
    private LocalDate updateDate;

    @Column(name = "catagory") //휴가 종류
    private String vacationType;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String requestStatus;

    @ManyToOne
    @JoinColumn(name = "emp_idx")
    private Employee employee;
}
