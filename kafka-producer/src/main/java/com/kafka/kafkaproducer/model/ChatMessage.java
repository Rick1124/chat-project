package com.kafka.kafkaproducer.model;

import java.util.Date;

enum Status {
    Sent,
    Received,
    Seen,
    Error
}

public class ChatMessage{

    private int id;
    private ChatMessage chatMessageId;
    private String content;
    private Date createDate;
    private Status status;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatMessage getChatMessageId() {
        return chatMessageId;
    }

    public void setChatMessageId(ChatMessage chatMessageId) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
