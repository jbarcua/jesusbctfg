package com.tfm.microservices.statistics.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table
@Data
public class StatisticData {
    @Id
    private String id;
    private String sensorId;
    private Timestamp insertionTime;
    private String type;
    private String value;
}