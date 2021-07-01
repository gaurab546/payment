package com.example.payment.service;

import com.example.payment.domain.Payment;
import com.example.payment.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService (PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public void registerPayment(Payment payment) {
        paymentRepository.save(payment);
    }
}
