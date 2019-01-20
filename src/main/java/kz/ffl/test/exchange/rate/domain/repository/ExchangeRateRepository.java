package kz.ffl.test.exchange.rate.domain.repository;

import kz.ffl.test.exchange.rate.domain.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findByCurrency(String currency);

}
