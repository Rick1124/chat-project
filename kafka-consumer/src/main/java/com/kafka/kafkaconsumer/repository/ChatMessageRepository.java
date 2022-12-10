package com.kafka.kafkaconsumer.repository;

import com.kafka.kafkaconsumer.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {
}
