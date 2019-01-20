package kz.ffl.test.exchange.rate.server.controller;

import kz.ffl.test.exchange.rate.server.service.api.ExchangeRateServiceApi;
import kz.ffl.test.exchange.rate.server.service.api.domain.ExchangeRateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateServiceApi service;

    @GetMapping("/exchange-rates")
    public List<ExchangeRateDTO> getExchangeRates(){
        return service.findAll();
    }

    @GetMapping("/exchange-rates/{currency}")
    public ExchangeRateDTO getExchangeRateByCurrency(@PathVariable("currency") String currency){
        return service.findByCurrency(currency.toUpperCase());
    }

}
