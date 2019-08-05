package com.jdcomponents.simplecontrollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api")
public class HelloWorldController {

    private Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/v1")
    public HelloWorld sayHelloReqParam(@RequestParam(name = "content", defaultValue = "Hello World!") String message) {
        log.info("Calling the hello world");
        return new HelloWorld(1, message);
    }

    @GetMapping("/v1/{content}")
    public HelloWorld sayHelloPathVar(@PathVariable(name = "content") String message) {
        MDC.put("history_event_data", "testing history value");
        log.info("Calling the content vars api");
        MDC.clear();
        return new HelloWorld(1, message);
    }

    @GetMapping("/v1/appname")
    public HelloWorld sayName() {
        log.info("Called appname controller...");
        return new HelloWorld(1, applicationName);
    }


}
