package com.example.demo.service.impl;

import com.example.demo.currency.Currency;
import com.example.demo.service.AmountService;
import com.example.demo.domain.Amount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AmountServiceImpl implements AmountService {

    @Override
    public List<Amount> calculateAmount(List<Amount> amountList){
        Map<Currency, BigDecimal> amountMap = new HashMap<>();
        for (Amount amount : amountList) {
            amountMap.computeIfPresent(amount.getCurrency(),(k,v)->v.add(amount.getCount()));
        }
        List<Amount> amounts = amountMap.entrySet()
                .stream()
                .map(e -> new Amount(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        for (Amount amount : amounts) {
            if (amount.getCount().compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException();
            }
        }
        return amounts;
    }
}
