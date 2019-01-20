package kz.ffl.test.exchange.rate.fetcher.service.egov.mapper;

import kz.ffl.test.exchange.rate.domain.model.ExchangeRate;
import kz.ffl.test.exchange.rate.fetcher.service.api.domain.ExchangeRateFetcherDTO;

import java.util.Date;

public abstract class ExchangeRateFetcherMapperDecorator implements ExchangeRateFetcherMapper {

    private final ExchangeRateFetcherMapper delegate;

    ExchangeRateFetcherMapperDecorator(ExchangeRateFetcherMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public ExchangeRate exchangeRateFetcherDTOToEntity(ExchangeRateFetcherDTO exchangeRateFetcherDTO) {
        ExchangeRate exchangeRate = delegate.exchangeRateFetcherDTOToEntity(exchangeRateFetcherDTO);
        exchangeRate.setUpdated(new Date());
        return exchangeRate;
    }
}
