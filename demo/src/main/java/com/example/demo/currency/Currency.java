package com.example.demo.currency;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
    USD,
    HKD,
    CYN
    ;

    @JsonValue
    @Override
    public String toString() {
        return super.toString();
    }
}
