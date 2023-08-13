package com.study.compicafe.order.entity;

import javax.persistence.*;

@Entity(name = "order")
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column(name = "order_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderCode;

    @Column(name = "oder_date", length = 8)
    private String orderDate;


}
