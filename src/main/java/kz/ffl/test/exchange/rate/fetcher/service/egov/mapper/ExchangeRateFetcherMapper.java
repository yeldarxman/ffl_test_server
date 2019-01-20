package kz.ffl.test.exchange.rate.fetcher.service.egov.mapper;

import kz.ffl.test.exchange.rate.domain.model.ExchangeRate;
import kz.ffl.test.exchange.rate.fetcher.service.api.domain.ExchangeRateFetcherDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(ExchangeRateFetcherMapperDecorator.class)
public interface ExchangeRateFetcherMapper {
    ExchangeRateFetcherMapper INSTANCE = Mappers.getMapper(ExchangeRateFetcherMapper.class);

    @Mappings(
            @Mapping(target = "id", ignore = true)
    )
    ExchangeRate exchangeRateFetcherDTOToEntity(ExchangeRateFetcherDTO exchangeRateFetcherDTO);
}
