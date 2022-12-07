package com.kafka.kafkaconsumer.service;

import com.kafka.kafkaconsumer.model.ChatMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "chat_message", groupId = "group_json")
    public void chatMessage(ConsumerRecord<Long, ChatMessage> record) throws IOException {
        System.out.println("Received Message: \n" + record.value());
    }
}