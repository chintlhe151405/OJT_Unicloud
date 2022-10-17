package com.example.demoexception_2.model.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@ToString
@Builder
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "description")
    private String description;

    public Message() {

    }

    public Message(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
