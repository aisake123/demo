package com.example.demo.service;

import com.example.demo.domain.Amount;

import java.util.List;

public interface AmountService {
    List<Amount> calculateAmount(List<Amount> amountList);
}
