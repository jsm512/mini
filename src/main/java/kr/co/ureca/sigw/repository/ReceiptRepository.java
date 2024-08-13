package kr.co.ureca.sigw.repository;

import kr.co.ureca.sigw.dto.ReceiptResponseDTO;
import kr.co.ureca.sigw.entity.Approval;
import kr.co.ureca.sigw.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

}
