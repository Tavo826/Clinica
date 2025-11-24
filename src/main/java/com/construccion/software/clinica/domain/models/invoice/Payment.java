package com.construccion.software.clinica.domain.models.invoice;

import java.math.BigDecimal;

public class Payment {

    private BigDecimal coPayment;
    private BigDecimal insurePayment;
    private BigDecimal totalPayment;

    public BigDecimal getCoPayment() {
        return coPayment;
    }

    public void setCoPayment(BigDecimal coPayment) {
        this.coPayment = coPayment;
    }

    public BigDecimal getInsurePayment() {
        return insurePayment;
    }

    public void setInsurePayment(BigDecimal insurePayment) {
        this.insurePayment = insurePayment;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }
}
