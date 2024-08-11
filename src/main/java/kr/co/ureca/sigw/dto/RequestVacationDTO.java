package kr.co.ureca.sigw.dto;

//목록 조회할 때 사용

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class RequestVacationDTO {

    private Long requestId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String requestStatus;
    private String vacationType;

}
