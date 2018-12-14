package com.jdcomponents.basichttpcalls;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController(value = "FetchController")
public class BasicHTTPCalls {

    @Value("${spring.goservice.uri}")
    private String goUri;

    @GetMapping("v1/fetchdatafromgo")
    public String fetchDataFromGo() {
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject(goUri, String.class);
        return res;
    }

}
