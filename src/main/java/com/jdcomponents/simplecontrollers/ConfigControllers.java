package com.jdcomponents.simplecontrollers;

import com.jdcomponents.dynamicconfigs.DynamicConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "DynamicConfigController")
public class ConfigControllers {

    @Autowired
    private DynamicConfigs dynamicConfigs;

    @GetMapping("v1/getConfig")
    public DynamicConfigs getConfig() {
        return dynamicConfigs;
    }

    @GetMapping("v1/updateRate")
    public boolean updateRate(@RequestParam(name = "rate") int rate) {
        dynamicConfigs.setRateOfRequest(rate);
        return true;
    }

}

/*

[jd@jdpc learningspringbootjd]$ curl localhost:8080/v1/getConfig
{"active":false,"version":"learningspringboot-0.0.1","rateOfRequest":78}

curl localhost:8080/v1/updateRate?rate=63
true

[jd@jdpc learningspringbootjd]$ curl localhost:8080/v1/getConfig
{"active":false,"version":"learningspringboot-0.0.1","rateOfRequest":63}

2018-12-14 22:28:00.001  INFO 524 --- [   scheduling-1] c.j.scheduletasks.MyTaskScheduler        : My name is learningspringboot and I'm running fine at rate 78
2018-12-14 22:29:00.001  INFO 524 --- [   scheduling-1] c.j.scheduletasks.MyTaskScheduler        : My name is learningspringboot and I'm running fine at rate 63

 */
