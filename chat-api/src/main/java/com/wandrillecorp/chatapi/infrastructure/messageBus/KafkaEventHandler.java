package com.wandrillecorp.chatapi.infrastructure.messageBus;

import com.wandrillecorp.avro.message.MessageAvro;
import com.wandrillecorp.chatapi.domain.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class KafkaEventHandler {

    private final SimpMessagingTemplate template;

    @Autowired
    public KafkaEventHandler(SimpMessagingTemplate template) {
        this.template = template;
    }

    @KafkaListener(topics = "chat")
    public void listen(MessageAvro messageAvro) {
        Message message = new Message()
                .setId(messageAvro.getId().toString())
                .setUserName(messageAvro.getUserName().toString())
                .setUserId(messageAvro.getUserId().toString())
                .setText(messageAvro.getText().toString())
                .setRoomId(messageAvro.getRoomId().toString())
                .setCreatedDate(messageAvro.getCreatedDate());
        template.convertAndSend("/chat", message);
    }

}
