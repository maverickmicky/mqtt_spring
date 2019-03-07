package com.micky.samples.mqtt.service;

import com.micky.samples.mqtt.config.MqttConfiguration;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    private MqttConfiguration.MqttGateway mqttGateway;

    public MqttService(MqttConfiguration.MqttGateway mqttGateway) {
        this.mqttGateway = mqttGateway;
    }

    public void sendMessage(String message) {
        mqttGateway.sendToMqtt(message);
    }
}
