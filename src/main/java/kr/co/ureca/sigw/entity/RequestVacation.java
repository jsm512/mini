package kr.co.ureca.sigw.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "created_date")
    private LocalDateTime requestDate;

    @Column(name = "updated_date")
    private LocalDateTime updateDate;

    @Column(name = "catagory") //휴가 종류
    private String vacationType;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "emp_idx")
    private Employee employee;
    //asdfasdf
    //asdfsadf
}
