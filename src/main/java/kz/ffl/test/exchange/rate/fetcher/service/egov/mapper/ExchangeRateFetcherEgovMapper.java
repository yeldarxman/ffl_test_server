package kz.ffl.test.exchange.rate.fetcher.service.egov.mapper;

import kz.ffl.test.exchange.rate.fetcher.service.api.domain.ExchangeRateFetcherDTO;
import kz.ffl.test.exchange.rate.fetcher.service.egov.domain.ExchangeRateEgovDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRateFetcherEgovMapper {

    ExchangeRateFetcherEgovMapper INSTANCE = Mappers.getMapper(ExchangeRateFetcherEgovMapper.class);

    @Mappings({
            @Mapping(source = "kurs", target = "rate"),
            @Mapping(source = "kod", target = "currency"),
            @Mapping(target = "updated", ignore = true)
    })
    ExchangeRateFetcherDTO egovDTOtoFetcherDTO(ExchangeRateEgovDTO egovDTO);

}
