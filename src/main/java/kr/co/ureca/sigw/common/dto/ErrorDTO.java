package kr.co.ureca.sigw.common.dto;

import kr.co.ureca.sigw.common.enumType.ErrorCode;
import kr.co.ureca.sigw.common.exception.CustomException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorDTO {
    private String code;
    private String msg;
    private String detail;

    public static ResponseEntity<ErrorDTO> toResponseEntity(CustomException ex){
        ErrorCode errorType = ex.getErrorCode();
        String detail = ex.getDetail();

        return ResponseEntity.status(ex.getStatus())
                .body(ErrorDTO.builder()
                        .code(errorType.getCode())
                        .msg(errorType.getMsg())
                        .detail(detail)
                        .build());
    }
}
