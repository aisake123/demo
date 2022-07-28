package com.example.demo.controller;

import com.example.demo.currency.Currency;
import com.example.demo.domain.Amount;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AmountControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void calculateAmountWhenSuccess(){
        Amount amount1 = Amount.builder()
                .currency(Currency.CYN)
                .count(BigDecimal.ONE)
                .build();
        Amount amount2 = Amount.builder()
                .currency(Currency.CYN)
                .count(BigDecimal.ONE)
                .build();
        List<Amount> list = Lists.list(amount1, amount2);
        List<Amount> body = testRestTemplate.getRestTemplate()
                .postForEntity("http://localhost:" + port + "/calculateAmount", list, List.class)
                .getBody();
        assertThat(body.size()).isEqualTo(1);
    }
}
