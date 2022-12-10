package com.kafka.kafkaproducer.model;

import com.kafka.kafkaconsumer.entity.ChatMessageEntity;

import java.io.Serializable;
import java.util.Date;

public class ChatMessage implements Serializable {

    private int id;
    private ChatMessageEntity chatMessageId;
    private String content;
    private Date createDate;
    private String status;

    public ChatMessage() {

    }

    public ChatMessage(ChatMessageEntity entity) {
        this.id = entity.getId();
        this.chatMessageId = entity.getChatMessageId();
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
        this.status = entity.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatMessageEntity getChatMessageId() {
        return chatMessageId;
    }

    public void setChatMessageId(ChatMessageEntity chatMessageId) {
        this.chatMessageId = chatMessageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", chatMessageId=" + chatMessageId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }
}
