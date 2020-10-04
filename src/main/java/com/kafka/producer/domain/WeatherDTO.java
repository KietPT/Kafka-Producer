package com.kafka.producer.domain;

import java.io.Serializable;

public class WeatherDTO implements Serializable {
    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
