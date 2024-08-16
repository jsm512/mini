package kr.co.ureca.test;

import kr.co.ureca.sigw.entity.Receipt;
import kr.co.ureca.sigw.repository.ReceiptRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaAuditingTest {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Test
    void test(){
        Receipt receipt = new Receipt();
        receipt.setPrice(100);
        receipt.setIdx(1);
        receipt.setUsedStore("버거킹");

        Receipt savedReceipt = receiptRepository.save(receipt);

    }
}
