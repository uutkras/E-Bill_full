package com.tcs.ebill.repository;

import com.tcs.ebill.entity.Bill;
import com.tcs.ebill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByUser(User user);
    Optional<Bill> findByBillNumber(String billNumber);
    List<Bill> findByIsPaidFalse();
} 