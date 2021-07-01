package com.example.payment.repo;

import com.example.payment.domain.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Integer> {
    Optional<List<PaymentRecord>> findAllByCustomerId(Integer customerId);
}
