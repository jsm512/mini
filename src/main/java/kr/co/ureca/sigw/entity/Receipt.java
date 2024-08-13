package kr.co.ureca.sigw.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity // JPA에서 테이블과 매핑시켜줄 때
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idx;

    int price;
    Date date;
    @Column(name = "used_store")
    String usedStore;

    @ManyToOne
    @JoinColumn(name = "doc_idx", nullable = false)
    private Document document;  // 외래 키 관계 매핑

    public Receipt(int idx, int price, Date date, String usedStore){

    }
}
