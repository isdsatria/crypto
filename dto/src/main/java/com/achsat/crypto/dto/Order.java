package com.achsat.crypto.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long coinId;
    private int coinCount;
    private int price;
    private String status;
    private String source;

    private Date transactionDate;


    public Order(Long id, Long customerId, Long coinId, String status) {
        this.id = id;
        this.customerId = customerId;
        this.coinId = coinId;
        this.status = status;
    }

    public Order(Long id, Long customerId, Long coinId, int coinCount, int price) {
        this.id = id;
        this.customerId = customerId;
        this.coinId = coinId;
        this.coinCount = coinCount;
        this.price = price;
        this.status = "NEW";
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + coinId +
                ", coinCount=" + coinCount +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
