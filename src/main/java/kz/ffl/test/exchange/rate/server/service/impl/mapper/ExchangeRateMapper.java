package kz.ffl.test.exchange.rate.server.service.impl.mapper;

import kz.ffl.test.exchange.rate.domain.model.ExchangeRate;
import kz.ffl.test.exchange.rate.server.service.api.domain.ExchangeRateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRateMapper {
    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);
    ExchangeRateDTO exchangeRateToDTO(ExchangeRate exchangeRate);
}
