package kr.co.ureca.sigw.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.ureca.sigw.dto.ReceiptResponseDTO;
import kr.co.ureca.sigw.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
