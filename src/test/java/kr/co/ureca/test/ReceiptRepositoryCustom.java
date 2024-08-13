package kr.co.ureca.test;

import kr.co.ureca.sigw.entity.Receipt;

import java.util.List;

public interface ReceiptRepositoryCustom {
    List<Receipt> findByIdx(int idx);
}
