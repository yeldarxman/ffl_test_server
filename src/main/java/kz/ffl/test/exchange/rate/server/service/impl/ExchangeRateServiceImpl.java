package kz.ffl.test.exchange.rate.server.service.impl;

import kz.ffl.test.exchange.rate.domain.repository.ExchangeRateRepository;
import kz.ffl.test.exchange.rate.server.service.api.ExchangeRateServiceApi;
import kz.ffl.test.exchange.rate.server.service.api.domain.ExchangeRateDTO;
import kz.ffl.test.exchange.rate.server.service.impl.mapper.ExchangeRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateServiceApi {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRateDTO> findAll() {
        return exchangeRateRepository.findAll().stream().map(ExchangeRateMapper.INSTANCE::exchangeRateToDTO).collect(Collectors.toList());
    }

    public ExchangeRateDTO findByCurrency(String currency){
        return ExchangeRateMapper.INSTANCE.exchangeRateToDTO(exchangeRateRepository.findByCurrency(currency));
    }

}
