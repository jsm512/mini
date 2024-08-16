package kr.co.ureca.sigw.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.ureca.sigw.common.enumType.ErrorCode;
import kr.co.ureca.sigw.common.exception.CustomException;
import kr.co.ureca.sigw.dto.ReceiptResponseDTO;
import kr.co.ureca.sigw.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // All List
    @Tag(name = "예제 API", description = "Swagger 테스트용 API")
    @GetMapping("/receipt")
    @ResponseBody
    public List<ReceiptResponseDTO> getReceiptList(){
        return boardService.getAllReceipt();
    }


    // 특정 id 리스트 뽑아오기
    @GetMapping("/receipt/{employeeId}")
    @ResponseBody
    public List<ReceiptResponseDTO> getReceiptListFindById(@PathVariable int employeeId){
        return boardService.getAllReceipt();
    }

    @GetMapping("/unauthorized")
    public ResponseEntity<Object> testCustomException() {
        try {
            throw new CustomException(HttpStatus.UNAUTHORIZED, ErrorCode.EXPIRED_TOKEN);
        }catch (Exception ex){
            throw new CustomException(ex);
        }
    }
}
