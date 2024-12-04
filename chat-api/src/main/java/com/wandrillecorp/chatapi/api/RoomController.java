package com.wandrillecorp.chatapi.api;

import com.wandrillecorp.chatapi.domain.room.Room;
import com.wandrillecorp.chatapi.domain.user.User;
import com.wandrillecorp.chatapi.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    public ResponseEntity<List<Room>> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable String id) {
        return roomService.getRoom(id);
    }

    @PostMapping()
    public ResponseEntity<User> createRoom(@RequestParam("userId") String userId,
                                           @RequestParam("roomName") String roomName) {
        return roomService.createRoom(userId, roomName);
    }
}
