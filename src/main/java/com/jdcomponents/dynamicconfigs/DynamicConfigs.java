package com.jdcomponents.dynamicconfigs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("dynamic")
public class DynamicConfigs {

    private boolean active;
    private String version;
    private int rateOfRequest;

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getRateOfRequest() {
        return this.rateOfRequest;
    }

    public void setRateOfRequest(int rateOfRequest) {
        this.rateOfRequest = rateOfRequest;
    }

}
