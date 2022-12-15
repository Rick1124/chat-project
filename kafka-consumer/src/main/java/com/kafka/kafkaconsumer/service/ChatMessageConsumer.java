package com.kafka.kafkaconsumer.service;

import com.kafka.kafkaconsumer.entity.ChatMessageEntity;
import com.kafka.kafkaproducer.model.ChatMessage;
import com.kafka.kafkaconsumer.repository.ChatMessageRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class ChatMessageConsumer {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @KafkaListener(topics = "chat-message-save-topic", groupId = "group-json10")
    public void saveChatMessage(ConsumerRecord<Long, ChatMessage> record) throws IOException {
        ChatMessage chatMessage = record.value();
        chatMessage.setCreateDate(new Date());
        ChatMessageEntity entity = new ChatMessageEntity(chatMessage);
        chatMessageRepository.save(entity);
    }

    @KafkaListener(topics = "chat-message-delete-topic", groupId = "group-json")
    public void deleteChatMessage(ConsumerRecord<Long,ChatMessage> record) throws IOException {
        chatMessageRepository.deleteById(record.value().getId());
    }
}