package com.tfm.microservices.statistics.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface StatisticsRepository extends CassandraRepository<StatisticData, UUID> {

  @AllowFiltering
  StatisticData findTopBySensorIdOrderByInsertionTime(String sensorId);
}