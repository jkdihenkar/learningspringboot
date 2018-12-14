package com.jdcomponents.scheduletasks;

import com.jdcomponents.dynamicconfigs.DynamicConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTaskScheduler {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private DynamicConfigs dynamicConfigs;

    private Logger logger = LoggerFactory.getLogger(MyTaskScheduler.class);

    @Scheduled(cron = "0 * * * * *")
    public void sayIAmRunning() {
        logger.info("My name is {} and I'm running fine at rate {}", appName, dynamicConfigs.getRateOfRequest());
    }

}
