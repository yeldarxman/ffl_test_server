package kz.ffl.test.exchange.rate.fetcher.daemon;

import kz.ffl.test.exchange.rate.fetcher.service.api.ExchangeRateFetcherServiceApi;
import kz.ffl.test.exchange.rate.fetcher.service.api.domain.ExchangeRateFetcherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ScheduledTasks {

    @Autowired
    private ExchangeRateFetcherServiceApi fetcherService;

    @Scheduled(fixedDelay = 600000) //runs every 10 minutes
    public void fetchAndSaveExchangeRates() {
        System.out.println("RUNNING THE SCHEDULED TASK...");
        List<ExchangeRateFetcherDTO> fetchedExchangeRates = fetcherService.fetchExchangeRates();
        fetcherService.saveExchangeRates(fetchedExchangeRates);
    }

}
