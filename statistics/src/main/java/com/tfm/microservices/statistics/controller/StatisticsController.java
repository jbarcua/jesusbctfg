package com.tfm.microservices.statistics.controller;

import com.tfm.microservices.statistics.pojo.request.SensorStatisticsRequest;
import com.tfm.microservices.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

@Controller
public class StatisticsController {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    StatisticsService statisticsService;

    @MessageMapping("/statistics/{sensorId}")
    public void send(@DestinationVariable String sensorId) throws Exception {
        scheduler.scheduleAtFixedRate(() -> {
            template.convertAndSend("/topic/statistics/" + sensorId, statisticsService.getSensorStatistics(sensorId));
        }, 0, 5, SECONDS);
    }
}
