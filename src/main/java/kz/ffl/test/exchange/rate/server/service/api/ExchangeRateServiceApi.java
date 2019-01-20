package kz.ffl.test.exchange.rate.server.service.api;

import kz.ffl.test.exchange.rate.server.service.api.domain.ExchangeRateDTO;

import java.util.List;

public interface ExchangeRateServiceApi {

    List<ExchangeRateDTO> findAll();

    ExchangeRateDTO findByCurrency(String currency);

}
