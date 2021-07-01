package com.example.payment.service;

import com.example.payment.repo.PaymentRecordRepository;
import com.example.payment.domain.PaymentRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PaymentRecordService {

    private PaymentRecordRepository paymentRecordRepository;
    public PaymentRecordService(PaymentRecordRepository paymentRecordRepository){
        this.paymentRecordRepository = paymentRecordRepository;
    }


    public ResponseEntity<String> makePayment(PaymentRecord paymentRecord) {
        if(paymentRecord.getAmount() <= 10) {
            log.info("the amount is {}", paymentRecord.getAmount());
            return new ResponseEntity("Payment too low", HttpStatus.NOT_ACCEPTABLE);

        }
        paymentRecordRepository.save(paymentRecord);
        return new ResponseEntity("Payment accepted", HttpStatus.OK);

    }

    public List<PaymentRecord> findAllById(Integer customerId) {
        List<PaymentRecord> amount =  paymentRecordRepository.findAllByCustomerId((customerId)).get();
        return amount;

    }
}
