package com.example.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentRecord {

    @Id
    private Integer bookingId;
    private Integer customerId;
    private Double amount;


}
