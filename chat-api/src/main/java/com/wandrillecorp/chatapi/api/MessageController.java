package com.wandrillecorp.chatapi.api;

import com.wandrillecorp.chatapi.dto.MessageCreateDto;
import com.wandrillecorp.chatapi.service.MessageService;
import com.wandrillecorp.chatapi.domain.message.Message;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5173", "http://localhost:3000"}, maxAge = 3600)
@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(
            MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public List<Message> getMessages() throws Exception {
        return messageService.getAllMessages();
    }

    @GetMapping("room/{roomId}")
    public List<Message> getMessagesByRoom(@PathVariable String roomId) throws Exception {
        return messageService.getAllMessagesByRoom(roomId);
    }

    @PostMapping("new")
    public void addNewMessage(
            @Valid @RequestBody MessageCreateDto command) {
        try {
            Message message = messageService.save(command.getUserId(),
                    command.getText(),
                    command.getRoomId());
            messageService.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
