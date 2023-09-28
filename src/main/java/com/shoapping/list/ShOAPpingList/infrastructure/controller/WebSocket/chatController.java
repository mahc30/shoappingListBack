package com.shoapping.list.ShOAPpingList.infrastructure.controller.WebSocket;

import com.shoapping.list.ShOAPpingList.application.dto.request.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class chatController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message) throws Exception {
        System.out.println(message);
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new Message(message.getFrom(), message.getText(), time);
    }

}
