package com.kafka.kafkaconsumer.controller;

import com.kafka.kafkaconsumer.entity.ChatMessageEntity;
import com.kafka.kafkaconsumer.model.ChatMessage;
import com.kafka.kafkaconsumer.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/chat-message")
public class ChatMessageController {
    @Autowired
    public ChatMessageRepository chatMessageRepository;

    @GetMapping("/{idChatMessage}")
    public ChatMessage getChatMessageById(@PathVariable("idChatMessage") int idChatMessage){
        if (idChatMessage <= 0)
            return null;

        ChatMessageEntity chatMessageEntity = chatMessageRepository.findById(idChatMessage).get();
        return new ChatMessage(chatMessageEntity);
    }
    @GetMapping("")
    public List<ChatMessage> getChatMessages(){
        List<ChatMessage> chatMessages = new ArrayList<>();

        List<ChatMessageEntity> entities = chatMessageRepository.findAll();
        for (ChatMessageEntity entity : entities){
            chatMessages.add(new ChatMessage(entity));
        }
        return chatMessages;

    }


}
