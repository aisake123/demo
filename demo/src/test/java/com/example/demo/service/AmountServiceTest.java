package com.example.demo.service;

import com.example.demo.currency.Currency;
import com.example.demo.domain.Amount;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
@SpringBootTest
public class AmountServiceTest {

    @Autowired
    private AmountService amountService;

    @Test
    public void calculateAmountWhenSuccess(){
        Amount amount1 = Amount.builder()
                .currency(Currency.CYN)
                .count(BigDecimal.ONE)
                .build();
        Amount amount2 = Amount.builder()
                .currency(Currency.USD)
                .count(BigDecimal.ONE)
                .build();
        List<Amount> list = Lists.list(amount1, amount2);
        List<Amount> amounts = amountService.calculateAmount(list);
        assertThat(amounts.size()).isEqualTo(2);
    }

    @Test
    public void calculateAmountWhenException(){
        Amount amount1 = Amount.builder()
                .currency(Currency.CYN)
                .count(BigDecimal.ONE)
                .build();
        Amount amount2 = Amount.builder()
                .currency(Currency.CYN)
                .count(BigDecimal.ZERO.subtract(BigDecimal.TEN))
                .build();
        List<Amount> list = Lists.list(amount1, amount2);
        try {
            amountService.calculateAmount(list);
        }catch (Exception e){
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
