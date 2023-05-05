package com.achsat.crypto.entity.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "coin_id")
    private Long coinId;
    @Column(name = "coin_count")
    private int coinCount;
    @Column(name = "price")
    private int price;
    @Column(name = "status")
    private String status;
    @Column(name = "source")
    private String source;
    @Column(name = "transaction_date")
    private Date transactionDate;

    public Order(Long id, Long customerId, Long coinId, int coinCount, int price) {
        this.id = id;
        this.customerId = customerId;
        this.coinId = coinId;
        this.coinCount = coinCount;
        this.price = price;
        this.status = "NEW";
    }

    public Order(Long id, Long customerId, Long coinId, int coinCount, int price, Date transactionDate, String source, String status) {
        this.id = id;
        this.customerId = customerId;
        this.coinId = coinId;
        this.coinCount = coinCount;
        this.price = price;
        this.status = status;
        this.source = "CONFIRMED";
        this.transactionDate = new Date();
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
