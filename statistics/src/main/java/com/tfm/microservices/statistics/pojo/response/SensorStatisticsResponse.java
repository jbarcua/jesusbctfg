package com.tfm.microservices.statistics.pojo.response;

import lombok.Data;

@Data
public class SensorStatisticsResponse {

    private String sensorId;
    private String value;
    private String type;
}
