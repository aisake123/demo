package com.example.demo.controller;

import com.example.demo.domain.Amount;
import com.example.demo.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AmountController {
    @Autowired
    private AmountService amountService;

    @PostMapping("/calculateAmount")
    public List<Amount> calculateAmount(@RequestBody List<Amount> amounts){
        return amountService.calculateAmount(amounts);
    }
}
