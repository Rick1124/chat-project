package com.kafka.kafkaproducer.controller;

import com.kafka.kafkaproducer.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, ChatMessage> kafkaUserTemplate;

    @GetMapping("/produce/{name}")
    public String myMessage(@PathVariable("name") final String name) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setName(name);
        kafkaUserTemplate.send("chat_message", chatMessage);
        return "Message Published Successfully";
    }
}