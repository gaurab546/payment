package com.example.payment.controller;

import com.example.payment.domain.Payment;
import com.example.payment.service.PaymentService;
import com.example.payment.domain.PaymentRecord;
import com.example.payment.dto.PaymentRequestDto;
import com.example.payment.service.PaymentRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class PaymentController {

    private PaymentRecordService paymentRecordService;
    private PaymentService paymentService;



    public PaymentController(PaymentRecordService paymentRecordService, PaymentService paymentService){
       this.paymentRecordService = paymentRecordService;
        this.paymentService = paymentService;

    }



    @PostMapping(value = "/payment-register")
    public ResponseEntity<String> paymentMade(@RequestBody Payment payment){
        paymentService.registerPayment(payment);
        return new ResponseEntity("Payment registered", HttpStatus.OK);
    }

    @PostMapping(value = "/payment/booking/{bookingId}")
    public ResponseEntity<String> paymentRequest(@RequestBody PaymentRequestDto paymentRequestDto,
                                                 @PathVariable Integer bookingId){
       PaymentRecord paymentRecord = new PaymentRecord();
       paymentRecord.setBookingId(bookingId);
       paymentRecord.setAmount(paymentRequestDto.getAmount());
       paymentRecord.setCustomerId(paymentRequestDto.getCustomerId());
       return paymentRecordService.makePayment(paymentRecord);

    }

    @GetMapping(value =  "/payment/getAll/{customerId}")
    public ResponseEntity<List<PaymentRecord>>  paymentRecord(@PathVariable Integer customerId){
        List<PaymentRecord> paymentRecords = paymentRecordService.findAllById(customerId);
        return new ResponseEntity<>(paymentRecords, HttpStatus.OK);

    }




}
