package kr.co.ureca.sigw.service;

import kr.co.ureca.sigw.dto.ReceiptResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    List<ReceiptResponseDTO> getAllReceipt();
}
