package kr.co.ureca.sigw.service;

import kr.co.ureca.sigw.dto.ReceiptResponseDTO;
import kr.co.ureca.sigw.entity.Receipt;
import kr.co.ureca.sigw.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReceiptServiceImpl implements BoardService{

    private final ReceiptRepository receiptRepository;

    @Override
    public List<ReceiptResponseDTO> getAllReceipt() {
        List<Receipt> receipts = receiptRepository.findAll();
        return receipts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private ReceiptResponseDTO convertToDTO(Receipt receipt) {
        return ReceiptResponseDTO.builder()
                .id(receipt.getIdx())
                .price(receipt.getPrice())
                .date(String.valueOf(receipt.getDate()))
                .usedStore(receipt.getUsedStore())
                .build();
    }

}
