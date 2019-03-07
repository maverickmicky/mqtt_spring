package com.micky.samples.mqtt.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.integration.mqtt.event.MqttConnectionFailedEvent;
import org.springframework.integration.mqtt.event.MqttMessageDeliveredEvent;
import org.springframework.integration.mqtt.event.MqttMessageSentEvent;
import org.springframework.integration.mqtt.event.MqttSubscribedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MqttEventListener<E extends ApplicationEvent> implements ApplicationListener<E> {

    Logger log = Logger.getLogger(MqttEventListener.class.getName());

    @Override
    public void onApplicationEvent(E event) {

        if (event instanceof MqttSubscribedEvent) {
            log.info("MqttSubscribedEvent " + ((MqttSubscribedEvent) event).getMessage());
        } else if (event instanceof MqttConnectionFailedEvent) {
            log.info("MqttConnectionFailedEvent " + ((MqttConnectionFailedEvent) event).getCause());
        } else if (event instanceof MqttMessageSentEvent) {
            log.info("MqttMessageSentEvent " + ((MqttMessageSentEvent) event).getMessage());
        } else if (event instanceof MqttMessageDeliveredEvent) {
            log.info("MqttMessageDeliveredEvent " + ((MqttMessageDeliveredEvent) event).getCause());
        }
    }
}
