package com.kafka.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final String TOPIC = "topic_weather";
    public static long NUMBER_MESSAGE_SENT = 0L;
    public static long NUMBER_MESSAGE_CONFIRM = 0L;
    private KafkaTemplate<String, String> kafkaTemplate;
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println(String.format("Producing message to %s : %s", TOPIC , message));
        this.kafkaTemplate.send(TOPIC, message);
        NUMBER_MESSAGE_SENT++;
    }
    public void confirmMessage() {
        NUMBER_MESSAGE_CONFIRM++;
    }
    public long getNumberMessageSent() {
        return NUMBER_MESSAGE_SENT;
    }
    public long getNumberMessageConfirm() {
        return NUMBER_MESSAGE_CONFIRM;
    }
}
