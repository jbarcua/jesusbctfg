package com.tfm.microservices.statistics.service;

import com.tfm.microservices.statistics.pojo.response.SensorStatisticsResponse;

public interface StatisticsService {

    SensorStatisticsResponse getSensorStatistics(String sensorId);

}
