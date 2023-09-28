package com.shoapping.list.ShOAPpingList.application.dto.request;

import lombok.Data;

@Data
public class Message {

    private String from;
    private String text;
    private String time;

    public Message(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }
}