package com.nailandcolour;

import java.math.BigDecimal;

public class Manicure implements Service {
    @Override
    public BigDecimal price() {
        return new BigDecimal("50");
    }

    @Override
    public String toString() {
        return "Manicure{}";
    }
}
