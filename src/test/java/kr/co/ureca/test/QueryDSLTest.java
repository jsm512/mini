package kr.co.ureca.test;


import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.ureca.sigw.entity.QReceipt;
import kr.co.ureca.sigw.entity.Receipt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QueryDSLTest {

    @PersistenceContext
    EntityManager entityManager;

//    @Test
//    void queryDSLTest4(){
//        JPAQueryFactory factory = new JPAQueryFactory(entityManager);
//        QReceipt qReceipt = QReceipt.receipt;
//        List<Receipt> list = factory.select(
//                    qReceipt.date
//                ,   qReceipt.idx
//                ,   qReceipt.price
//                )
//                .from(qReceipt)
//                .where()
//                .fetch();
//    }

    void queryDSLTest2(){
        JPAQueryFactory factory = new JPAQueryFactory(entityManager);
        QReceipt qReceipt = QReceipt.receipt;
        // List<Receipt> list = factory.from(qReceipt).fetch();
    }

    //@Test
    void queryDslTest(){ // 1단계
        JPAQuery<Receipt> query = new JPAQuery<>(entityManager);
        QReceipt qReceipt = QReceipt.receipt;

        List<Receipt> list = query.from(qReceipt).fetch();

    }

}
