package com.micky.samples.mqtt.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MqttSubscriber implements MessageHandler {

    Logger log = Logger.getLogger(MqttSubscriber.class.getName());

    @Override
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(Message<?> message) throws MessagingException {
        log.info("Message received" + message.getPayload().toString());
    }
}
