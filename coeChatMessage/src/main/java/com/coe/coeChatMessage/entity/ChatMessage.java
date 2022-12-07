package com.coe.coeChatMessage.entity;

import jakarta.persistence.*;
import java.util.Date;

enum Status {
    Sent,
    Received,
    Seen,
    Error
}

@Entity
@Table(name = "chat_message")
public class ChatMessage{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "chat_message_fk", referencedColumnName = "id", nullable = false)
    private ChatMessage chatMessageId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(columnDefinition = "ENUM('ONLINE', 'OFFLINE')")
    @Enumerated(EnumType.STRING)
    private Status status;

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
}
