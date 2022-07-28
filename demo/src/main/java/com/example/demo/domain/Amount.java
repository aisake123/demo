package com.example.demo.domain;

import com.example.demo.currency.Currency;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Amount {

    Currency currency;

    BigDecimal count;

}
