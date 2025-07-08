package com.aroldev.messagingnetwork;

import com.aroldev.messagingnetwork.Enum.MessageType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String content;
    private long timestamp;
    private MessageType type;
    private String sender;

    public Message(String content,long timestamp, MessageType type, String sender) {
        this.sender = sender;
        this.type = type;
        this.timestamp = timestamp;
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String formatDate(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }
}
