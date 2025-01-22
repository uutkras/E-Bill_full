package com.tcs.ebill.service;

import com.tcs.ebill.entity.Bill;
import com.tcs.ebill.exception.ResourceNotFoundException;
import com.tcs.ebill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {
    private final BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + id));
    }

    public List<Bill> getPendingBills() {
        return billRepository.findByIsPaidFalse();
    }
} 