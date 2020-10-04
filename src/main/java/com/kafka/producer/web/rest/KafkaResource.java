package com.kafka.producer.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.domain.WeatherDTO;
import com.kafka.producer.service.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/kafka")
public class KafkaResource {

    private KafkaProducer kafkaProducer;
    public KafkaResource(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody WeatherDTO weatherDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String mess = objectMapper.writeValueAsString(weatherDTO);
        mess = "sendTime: " + Instant.now().toEpochMilli() + " - data: "+ mess;
        System.out.println(String.format("Request to send to Kafka topic the message %s ", mess));
        this.kafkaProducer.sendMessage(mess);
    }
    @PostMapping("/confirm")
    public void confirmMessage() {
        kafkaProducer.confirmMessage();
    }

    @PostMapping("/clear")
    public void clearMessage() {
        KafkaProducer.NUMBER_MESSAGE_SENT = 0;
        KafkaProducer.NUMBER_MESSAGE_CONFIRM = 0;
    }
    @GetMapping("/number-message-sent")
    public Long getNumberMessageSent() {
        return kafkaProducer.getNumberMessageSent();
    }

    @GetMapping("/diff")
    public Map<String, Long> getDifferent() {
        Map<String, Long> result = new HashMap<String, Long>();
        result.put("message sent", kafkaProducer.getNumberMessageSent());
        result.put("message receive", kafkaProducer.getNumberMessageConfirm());
        return result;
    }
    @GetMapping("/health-check")
    public ResponseEntity<String> checkHealth(){
        return new ResponseEntity<>("Check health successfully", HttpStatus.OK);
    }
}
