package com.tfm.microservices.statistics.service;

import com.tfm.microservices.statistics.mapper.StatisticsMapper;
import com.tfm.microservices.statistics.pojo.request.SensorStatisticsRequest;
import com.tfm.microservices.statistics.pojo.response.SensorStatisticsResponse;
import com.tfm.microservices.statistics.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public SensorStatisticsResponse getSensorStatistics(String sensorId) {
        return StatisticsMapper.MAPPER.statisticDataToStatisticResponse(statisticsRepository.findTopBySensorIdOrderByInsertionTime(sensorId));
    }
}
