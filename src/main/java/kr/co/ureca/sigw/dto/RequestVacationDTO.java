package kr.co.ureca.sigw.dto;

//목록 조회할 때 사용

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class RequestVacationDTO {

    private Long requestId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String requestStatus;
    private String vacationType;

}
