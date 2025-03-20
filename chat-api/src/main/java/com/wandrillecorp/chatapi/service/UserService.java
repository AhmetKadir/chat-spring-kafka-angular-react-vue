package com.wandrillecorp.chatapi.service;

import com.wandrillecorp.chatapi.domain.room.Room;
import com.wandrillecorp.chatapi.domain.room.RoomRepository;
import com.wandrillecorp.chatapi.domain.user.User;
import com.wandrillecorp.chatapi.domain.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public UserService(UserRepository userRepository,
                       RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    public User findOrCreateUser(String userName) {
        User existingUser = userRepository.findByName(userName);
        if (existingUser != null) {
            return existingUser;
        } else {
            User user = new User()
                    .setName(userName)
                    .setCreatedDate(Instant.now());
            return userRepository.save(user);
        }
    }

    public ResponseEntity<User> enterRoom(String userId, String roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        if (room.getNumberOfUsers() >= Room.ROOM_CAPACITY) {
            return ResponseEntity.badRequest().build();
        }
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            room.incrementNumberOfUsers();
            roomRepository.save(room);

            user.setRoomId(roomId);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
