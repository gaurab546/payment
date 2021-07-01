package com.example.payment.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Payment {

    @Id
    private Integer customerId;
    private String cardNumber;
    private Integer cvv;



}