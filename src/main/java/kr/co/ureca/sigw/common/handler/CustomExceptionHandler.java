package kr.co.ureca.sigw.common.handler;

import kr.co.ureca.sigw.common.dto.ErrorDTO;
import kr.co.ureca.sigw.common.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    // Exception을 처리하는 메소드
    // value: 어떤 예외를 처리할 것인지 정해주는 파라마티
    @ExceptionHandler (value = CustomException.class)
    public ResponseEntity<ErrorDTO> handleException(CustomException ex) {
        return ErrorDTO.toResponseEntity(ex);
    }
}
