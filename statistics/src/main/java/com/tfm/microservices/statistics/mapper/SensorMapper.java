package com.tfm.microservices.statistics.mapper;

import com.tfm.microservices.statistics.pojo.request.SensorStatisticsRequest;
import com.tfm.microservices.statistics.pojo.response.SensorStatisticsResponse;
import com.tfm.microservices.statistics.repository.StatisticData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SensorMapper {

  SensorMapper MAPPER = Mappers.getMapper(SensorMapper.class);

  SensorStatisticsRequest aaa(SensorStatisticsResponse statisticData);
}