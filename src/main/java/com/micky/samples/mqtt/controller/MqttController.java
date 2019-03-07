package com.micky.samples.mqtt.controller;

import com.micky.samples.mqtt.service.MqttService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController("/mqtt")
public class MqttController {

    public static final Logger log = LoggerFactory.getLogger(MqttController.class);

    @Autowired
    private MqttService service;

    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
    public void sendMessage(@RequestParam(value = "message", required = false) String message) {
        service.sendMessage(message);
        log.info("send message " );
    }

    @RequestMapping
    public void sendMessageNew(@RequestParam(value = "message", required = false) String message) {
        service.sendMessage(message);
        log.info("send message " + message);
    }
}
