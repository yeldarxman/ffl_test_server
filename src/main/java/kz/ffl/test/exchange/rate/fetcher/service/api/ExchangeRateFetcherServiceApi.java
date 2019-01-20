package kz.ffl.test.exchange.rate.fetcher.service.api;

import kz.ffl.test.exchange.rate.fetcher.service.api.domain.ExchangeRateFetcherDTO;

import java.util.List;

public interface ExchangeRateFetcherServiceApi {

    List<ExchangeRateFetcherDTO> fetchExchangeRates();

    void saveExchangeRates(List<ExchangeRateFetcherDTO> fetchedExchangeRates);

}
