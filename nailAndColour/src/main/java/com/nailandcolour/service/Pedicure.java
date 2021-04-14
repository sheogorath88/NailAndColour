package com.nailandcolour.service;

import com.nailandcolour.service.Service;

import java.math.BigDecimal;

public class Pedicure implements Service {
    @Override
    public BigDecimal price() {
        return new BigDecimal("80");
    }

    @Override
    public String toString() {
        return "Pedicure{}";
    }
}
