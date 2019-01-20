package kz.ffl.test.exchange.rate.fetcher.service.egov.service;

import com.google.gson.Gson;
import kz.ffl.test.exchange.rate.domain.model.ExchangeRate;
import kz.ffl.test.exchange.rate.domain.repository.ExchangeRateRepository;
import kz.ffl.test.exchange.rate.fetcher.service.api.ExchangeRateFetcherServiceApi;
import kz.ffl.test.exchange.rate.fetcher.service.api.domain.ExchangeRateFetcherDTO;
import kz.ffl.test.exchange.rate.fetcher.service.egov.domain.ExchangeRateEgovDTO;
import kz.ffl.test.exchange.rate.fetcher.service.egov.mapper.ExchangeRateFetcherEgovMapper;
import kz.ffl.test.exchange.rate.fetcher.service.egov.mapper.ExchangeRateFetcherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExchangeRateFetcherServiceEgovImpl implements ExchangeRateFetcherServiceApi {

    private static final String EXCHANGE_RATE_URL = "https://data.egov.kz/api/v2/valutalar_bagamdary4/v490?size=1000";

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;


    public List<ExchangeRateFetcherDTO> fetchExchangeRates() {
        String exchangeRates = null;
        HTTPClient httpClient = new HTTPClient();
        try {
            exchangeRates = httpClient.get(EXCHANGE_RATE_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(exchangeRates == null || exchangeRates.isEmpty()) {
            return new ArrayList<>();
        }

        List<ExchangeRateEgovDTO> currencyList = this.parseResponse(exchangeRates);
        return currencyList.stream().map(ExchangeRateFetcherEgovMapper.INSTANCE::egovDTOtoFetcherDTO).collect(Collectors.toList());
    }

    public void saveExchangeRates(List<ExchangeRateFetcherDTO> fetchedExchangeRates) {
        fetchedExchangeRates.forEach(fetchedExchangeRate -> {
            ExchangeRate exchangeRate = exchangeRateRepository.findByCurrency(fetchedExchangeRate.getCurrency());
            if(exchangeRate != null){
                fillOutFields(exchangeRate, fetchedExchangeRate);
                exchangeRateRepository.saveAndFlush(exchangeRate);
            } else {
                exchangeRateRepository.saveAndFlush(ExchangeRateFetcherMapper.INSTANCE.exchangeRateFetcherDTOToEntity(fetchedExchangeRate));
            }
        });
    }

    private List<ExchangeRateEgovDTO> parseResponse(String response) {
        Gson gson = new Gson();
        return Arrays.asList(gson.fromJson(response, ExchangeRateEgovDTO[].class));
    }

    private void fillOutFields(ExchangeRate exchangeRate, ExchangeRateFetcherDTO exchangeRateFetcherDTO){
        exchangeRate.setUpdated(new Date());
        exchangeRate.setCurrency(exchangeRateFetcherDTO.getCurrency());
        exchangeRate.setRate(exchangeRateFetcherDTO.getRate());
    }
}
