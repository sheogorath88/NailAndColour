package com.nailandcolour;

import java.math.BigDecimal;

public class Pedicure implements Service{
    @Override
    public BigDecimal price() {
        return new BigDecimal("80");
    }
}
