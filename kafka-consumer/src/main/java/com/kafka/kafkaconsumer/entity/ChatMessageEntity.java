package com.kafka.kafkaconsumer.entity;

import com.kafka.kafkaproducer.model.ChatMessage;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "chat_message")
public class ChatMessageEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "chat_message_fk", referencedColumnName = "id")
    private ChatMessageEntity chatMessageId;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "status")
    private String status;

    @Column(name = "chat_id")
    private int chatId;

    public ChatMessageEntity() {
    }

    public ChatMessageEntity(ChatMessage chatMessage) {
        this.id = chatMessage.getId();
        this.chatMessageId = chatMessage.getChatMessageId();
        this.content = chatMessage.getContent();
        this.createDate = chatMessage.getCreateDate();
        this.status = chatMessage.getStatus();
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

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "ChatMessageEntity{" +
                "id=" + id +
                ", chatMessageId=" + chatMessageId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }

    public void updateEntity(ChatMessage chatMessage){
        this.content = chatMessage.getContent();
    }
}
