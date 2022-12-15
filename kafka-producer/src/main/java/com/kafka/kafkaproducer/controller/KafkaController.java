package com.kafka.kafkaproducer.controller;

import com.kafka.kafkaproducer.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chat-message/produce")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, ChatMessage> kafkaUserTemplate;

    @Autowired
    private KafkaTemplate<String, Integer> kafkaIdChatMessageTemplate;

    @PostMapping("")
    public String saveChatMessage(@RequestBody ChatMessage chatMessage) {
        kafkaUserTemplate.send("chat-message-save-topic", chatMessage);
        return "Chat message saved successfully";
    }

    @DeleteMapping("/{idChatMessage}")
    public String deleteChatMessage(@PathVariable("idChatMessage") int idChatMessage){
        kafkaIdChatMessageTemplate.send("chat-message-delete-topic", idChatMessage);
        return "Chat message deleted successfully";
    }

}