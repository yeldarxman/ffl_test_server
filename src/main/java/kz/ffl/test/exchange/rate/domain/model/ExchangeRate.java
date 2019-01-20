package kz.ffl.test.exchange.rate.domain.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {
    private Long id;
    private Date updated;
    private BigDecimal rate;
    private String currency;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Column(name = "currency", unique = true)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", updated=" + updated +
                ", rate=" + rate +
                ", currency='" + currency + '\'' +
                '}';
    }
}
