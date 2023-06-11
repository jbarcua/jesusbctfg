package com.tfm.microservices.statistics.mapper;

import com.tfm.microservices.statistics.pojo.response.SensorStatisticsResponse;
import com.tfm.microservices.statistics.repository.StatisticData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatisticsMapper {

  StatisticsMapper MAPPER = Mappers.getMapper(StatisticsMapper.class);

  SensorStatisticsResponse statisticDataToStatisticResponse(StatisticData statisticData);
}