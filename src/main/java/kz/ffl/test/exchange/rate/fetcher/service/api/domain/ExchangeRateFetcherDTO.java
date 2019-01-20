package kz.ffl.test.exchange.rate.fetcher.service.api.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ExchangeRateFetcherDTO {

    private Date updated;
    private BigDecimal rate;
    private String currency;

    public ExchangeRateFetcherDTO() {
    }

    public ExchangeRateFetcherDTO(Date updated, BigDecimal rate, String currency) {
        this.updated = updated;
        this.rate = rate;
        this.currency = currency;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
